package designpatterns.basics.comportamento.observer.job;

import designpatterns.basics.comportamento.observer.model.Lancamento;
import designpatterns.basics.comportamento.observer.notitifcador.Notificador;
import designpatterns.basics.comportamento.observer.repository.LancamentoRepository;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.List;

public class LancamentosVencidosJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap jobDataMap = context.getJobDetail().getJobDataMap();

        LancamentoRepository lancamentos = (LancamentoRepository) jobDataMap.get("lancamentoRepository");
        List<Lancamento> lancamentosVencidos = lancamentos.todosVencidos();

        /*OuvinteEmail ouvinteEmail = (OuvinteEmail) jobDataMap.get("enviadorEmail");
        OuvinteSMS ouvinteSms = (OuvinteSMS) jobDataMap.get("enviadorSms");
        ouvinteEmail.atualizar(lancamentosVencidos);
        ouvinteSms.atualizar(lancamentosVencidos);*/

        Notificador notificador = (Notificador) jobDataMap.get("notificador");
        notificador.novosLancamentosVencidos(lancamentosVencidos);

    }

}
