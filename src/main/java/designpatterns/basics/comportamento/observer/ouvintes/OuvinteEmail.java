package designpatterns.basics.comportamento.observer.ouvintes;

import designpatterns.basics.comportamento.observer.model.Lancamento;
import designpatterns.basics.comportamento.observer.notitifcador.Notificador;

import java.util.List;

public class OuvinteEmail implements Ouvinte {

    private final Notificador notificador;

    public OuvinteEmail(Notificador notificador) {
        this.notificador = notificador;
        notificador.registrar(this);
    }

    @Override
    public void atualizar(List<Lancamento> lancamentosVencidos) {
        for (Lancamento lancamento : lancamentosVencidos) {
            System.out.println("Enviando e-mail para " + lancamento.getPessoa().getEmail());
        }
    }

    @Override
    public void atualizar() {
        var lancamentos = this.notificador.getLancamentosVencidos();
        for (var lancamento : lancamentos) {
            System.out.println("Enviando e-mail para " + lancamento.getPessoa().getEmail());
        }
    }

}
