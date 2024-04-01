package designpatterns.basics.criacao.factory.method.exercicio;

public class LoggerConsole implements Logger{
    @Override
    public void log(String mensagem) {
        System.out.println(mensagem);
    }
}
