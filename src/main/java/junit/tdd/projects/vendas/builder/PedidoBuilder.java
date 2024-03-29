package junit.tdd.projects.vendas.builder;

import junit.tdd.projects.vendas.model.Cliente;
import junit.tdd.projects.vendas.model.Pedido;
import junit.tdd.projects.vendas.model.StatusPedido;

public class PedidoBuilder {
    private Pedido instancia;

    public PedidoBuilder() {
        instancia = new Pedido();
    }

    public Pedido construir() {
        return instancia;
    }

    public PedidoBuilder comValor(double valor) {
        instancia.setValor(valor);
        return this;
    }

    public PedidoBuilder comStatus(StatusPedido status) {
        instancia.setStatus(status);
        return this;
    }

    public PedidoBuilder para(String nome, String email, String telefone) {
        Cliente cliente = new Cliente(nome, email, telefone);
        instancia.setCliente(cliente);
        return this;
    }
}
