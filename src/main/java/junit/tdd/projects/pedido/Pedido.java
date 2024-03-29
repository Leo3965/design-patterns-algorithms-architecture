package junit.tdd.projects.pedido;

import junit.tdd.projects.pedido.desconto.CalculadoraFaixaDesconto;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private final CalculadoraFaixaDesconto calculadoraFaixaDesconto;
    List<Item> itens;
    private double desconto;

    public Pedido(CalculadoraFaixaDesconto calculadoraFaixaDesconto) {
        this.calculadoraFaixaDesconto = calculadoraFaixaDesconto;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public ResumoPedido resumo() {
        double valorTotal = itens.stream()
                .mapToDouble(i -> i.getValor() * i.getQuantidade())
                .sum();
        double desconto = calculadoraFaixaDesconto.desconto(valorTotal);
        return new ResumoPedido(valorTotal, desconto);

    }
}
