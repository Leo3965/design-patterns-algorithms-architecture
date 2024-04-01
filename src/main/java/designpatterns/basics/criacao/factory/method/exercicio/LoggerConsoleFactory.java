package designpatterns.basics.criacao.factory.method.exercicio;

public class LoggerConsoleFactory extends LoggerFactory {
    @Override
    protected Logger build() {
        return new LoggerConsole();
    }
}
