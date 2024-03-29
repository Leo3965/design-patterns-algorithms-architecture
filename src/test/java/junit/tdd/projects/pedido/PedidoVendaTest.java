package junit.tdd.projects.pedido;

import junit.tdd.projects.pedido.desconto.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PedidoVendaTest {
    private static Pedido pedido;

    @BeforeEach
    void setUp() {
        CalculadoraFaixaDesconto calculadoraFaixaDesconto = new CalculadoraDescontoTerceiraFaixa(
                new CalculadoraDescontoSegundaFaixa(
                        new CalculadoraDescontoPrimeiraFaixa(
                                new CalculadoraSemDesconto(null)
                        )
                )
        );
        pedido = new Pedido(calculadoraFaixaDesconto);
    }

    private void assertResumoPedido(double valorTotal, double desconto) {
        var resumo = pedido.resumo();
        Assertions.assertThat(resumo.getValorTotal()).isEqualTo(valorTotal);
        Assertions.assertThat(resumo.getDesconto()).isEqualTo(desconto);
    }

    @Test
    void deveCalcularValorTotalEDescontoParaPedidoVazio() {
        assertResumoPedido(0, 0);
    }

    @Test
    void deveCaclcularResumoParaUmItemSemDesconto() {
        pedido.adicionarItem(new Item("Sabonete", 5.0, 5));
        assertResumoPedido(25, 0);
    }

    @Test
    void deveCalcularResumoParaDoisItens() {
        pedido.adicionarItem(new Item("Shampoo", 7, 3));
        pedido.adicionarItem(new Item("Pasta de dente", 3, 3));
        assertResumoPedido(30, 0);
    }

    @Test
    void deveAplicarDescontoNaPrimeiraFaixa() {
        pedido.adicionarItem(new Item("Creme", 20, 20));
        assertResumoPedido(400, 16);
    }

    @Test
    void deveAplicarDescontoNaSegundaFaixa() {
        pedido.adicionarItem(new Item("Shampoo", 15, 30));
        pedido.adicionarItem(new Item("Óleo", 15, 30));
        assertResumoPedido(900, 54);
    }

    @Test
    void deveAplicarDescontoNaTerceiraFaixa() {
        pedido.adicionarItem(new Item("Creme", 15, 30));
        pedido.adicionarItem(new Item("Óleo", 15, 30));
        pedido.adicionarItem(new Item("Shampoo", 10, 30));

        assertResumoPedido(1200, 96);
    }
}