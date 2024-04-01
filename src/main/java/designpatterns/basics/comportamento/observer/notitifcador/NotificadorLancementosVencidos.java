package designpatterns.basics.comportamento.observer.notitifcador;

import designpatterns.basics.comportamento.observer.model.Lancamento;
import designpatterns.basics.comportamento.observer.ouvintes.Ouvinte;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NotificadorLancementosVencidos implements Notificador {
    private Set<Ouvinte> ouvintes;
    private List<Lancamento> lancamentosVencidos;

    public NotificadorLancementosVencidos() {
        ouvintes = new HashSet<>();
        lancamentosVencidos = new ArrayList<>();
    }

    @Override
    public void registrar(Ouvinte ouvinte) {
        ouvintes.add(ouvinte);
    }

    @Override
    public void remover(Ouvinte ouvinte) {
        ouvintes.remove(ouvinte);
    }

    @Override
    public void notificarOuvintes() {
        for (var o : ouvintes) {
            o.atualizar(lancamentosVencidos);
        }
    }

    @Override
    public void novosLancamentosVencidos(List<Lancamento> lancamentosVencidos) {
        this.lancamentosVencidos = lancamentosVencidos;
        notificarOuvintes();
    }

    @Override
    public List<Lancamento> getLancamentosVencidos() {
        return this.lancamentosVencidos;
    }
}
