package junit.tdd.projects.pedido.desconto;

public class CalculadoraSemDesconto extends CalculadoraFaixaDesconto {
    public CalculadoraSemDesconto(CalculadoraFaixaDesconto proximo) {
        super(proximo);
    }

    @Override
    protected double calcular(double valorTotal) {
        return 0;
    }
}
