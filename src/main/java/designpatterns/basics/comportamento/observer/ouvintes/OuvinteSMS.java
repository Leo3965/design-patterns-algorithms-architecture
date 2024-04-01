package designpatterns.basics.comportamento.observer.ouvintes;

import designpatterns.basics.comportamento.observer.model.Lancamento;
import designpatterns.basics.comportamento.observer.notitifcador.Notificador;

import java.util.List;

public class OuvinteSMS implements Ouvinte {

    private final Notificador notificador;

    public OuvinteSMS(Notificador notificador) {
        this.notificador = notificador;
        notificador.registrar(this);
    }

    @Override
    public void atualizar(List<Lancamento> lancamentosVencidos) {
        for (Lancamento lancamento : lancamentosVencidos) {
            System.out.println("Enviando SMS para " + lancamento.getPessoa().getTelefone());
        }

        //this.notificador.remover(this);
    }

    @Override
    public void atualizar() {
        var lancamentos = this.notificador.getLancamentosVencidos();
        for (var l : lancamentos) {
            System.out.println("Enviando SMS para " + l.getPessoa().getTelefone());
        }
    }
}
