package designpatterns.basics.criacao.factory.method.exercicio;

public class Principal {
    public static void main(String[] args) {
        var fabrica = new LoggerConsoleFactory();
        Logger logger = fabrica.build();
        var calculadora = new CalculadoraDeImpostos(logger);
        calculadora.calcular(10);
    }
}
