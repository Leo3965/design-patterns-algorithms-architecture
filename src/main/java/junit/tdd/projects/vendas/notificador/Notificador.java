package junit.tdd.projects.vendas.notificador;

import junit.tdd.projects.vendas.model.Pedido;

public interface Notificador {
    void enviar(Pedido pedido);
}
