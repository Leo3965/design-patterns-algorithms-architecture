package designpatterns.basics.comportamento.observer.ouvintes;

import designpatterns.basics.comportamento.observer.model.Lancamento;
import designpatterns.basics.comportamento.observer.notitifcador.Notificador;

import java.util.List;

public interface Ouvinte {
    void atualizar(List<Lancamento> lancamentosVencidos);
    void atualizar();
}
