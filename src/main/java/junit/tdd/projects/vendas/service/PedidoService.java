package junit.tdd.projects.vendas.service;

import junit.tdd.projects.vendas.model.Pedido;
import junit.tdd.projects.vendas.model.StatusPedido;
import junit.tdd.projects.vendas.notificador.Notificador;
import junit.tdd.projects.vendas.repository.Pedidos;

import java.util.List;

public class PedidoService {

    private final Pedidos banco;
    private final List<Notificador> notificacoes;

    public PedidoService(Pedidos banco, List<Notificador> notificacoes) {
        this.banco = banco;
        this.notificacoes = notificacoes;
    }

    public double lancar(Pedido pedido) {
        double imposto = pedido.getValor() * 0.1;
        banco.guardar(pedido);
        notificacoes.forEach(n -> n.enviar(pedido));
        return imposto;
    }

    public Pedido pagar(Long codigoPedido) {
        var pedido = banco.buscarPeloCodigo(codigoPedido);

        if (!pedido.getStatus().equals(StatusPedido.PENDENTE)) {
            throw new PedidoInvalidoException();
        }
        pedido.setStatus(StatusPedido.PAGO);
        return pedido;
    }
}
