package junit.tdd.projects.pedido.desconto;

public class CalculadoraDescontoPrimeiraFaixa extends CalculadoraFaixaDesconto {
    public CalculadoraDescontoPrimeiraFaixa(CalculadoraFaixaDesconto proximo) {
        super(proximo);
    }

    @Override
    protected double calcular(double valorTotal) {
        if (valorTotal > 300 && valorTotal <= 800) {
            return valorTotal * 0.04;
        }

        return -1;
    }
}
