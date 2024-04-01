package designpatterns.basics.comportamento.observer;

import designpatterns.basics.comportamento.observer.job.LancamentosVencidosJob;
import designpatterns.basics.comportamento.observer.notitifcador.Notificador;
import designpatterns.basics.comportamento.observer.notitifcador.NotificadorLancementosVencidos;
import designpatterns.basics.comportamento.observer.ouvintes.Ouvinte;
import designpatterns.basics.comportamento.observer.repository.LancamentoRepository;
import designpatterns.basics.comportamento.observer.ouvintes.OuvinteEmail;
import designpatterns.basics.comportamento.observer.ouvintes.OuvinteSMS;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class Principal {
    public static void main(String[] args) throws Exception {
        LancamentoRepository lancamentos = new LancamentoRepository();
        Notificador notificador = new NotificadorLancementosVencidos();
        Ouvinte ouvinteEmail = new OuvinteEmail(notificador);
        Ouvinte ouvinteSms = new OuvinteSMS(notificador);


        JobDataMap jobDataMap = new JobDataMap();
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        jobDataMap.put("lancamentoRepository", lancamentos);
//        jobDataMap.put("enviadorEmail", ouvinteEmail);
//        jobDataMap.put("enviadorSms", ouvinteSms);
        jobDataMap.put("notificador", notificador);

        JobDetail job = newJob(LancamentosVencidosJob.class)
                .setJobData(jobDataMap)
                .withIdentity("lancamentosVencidosJob", "lancamentosVencidosGroup")
                .build();

        CronTrigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule("0 * * * * ?"))
                .build();

        scheduler.scheduleJob(job, trigger);

        scheduler.start();

        Thread.sleep(220000);

        scheduler.shutdown(true);
    }
}
