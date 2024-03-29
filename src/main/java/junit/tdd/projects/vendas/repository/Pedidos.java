package junit.tdd.projects.vendas.repository;

import junit.tdd.projects.vendas.model.Pedido;

public class Pedidos {
    private Pedido pedido;
    public void guardar(Pedido pedido) {
        System.out.println("Salvando no banco de dados... ");
        this.pedido = pedido;
    }

    public Pedido buscarPeloCodigo(Long id) {
        return pedido;
    }
}
