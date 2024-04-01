package designpatterns.basics.comportamento.observer.notitifcador;

import designpatterns.basics.comportamento.observer.model.Lancamento;
import designpatterns.basics.comportamento.observer.ouvintes.Ouvinte;

import java.util.List;

public interface Notificador {
    void registrar(Ouvinte ouvinte);
    void remover(Ouvinte ouvinte);
    void notificarOuvintes();
    void novosLancamentosVencidos(List<Lancamento> lancamentosVencidos);
    List<Lancamento> getLancamentosVencidos();
}
