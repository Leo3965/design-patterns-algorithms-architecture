package designpatterns.basics.criacao.factory.method.exercicio;

import java.time.LocalDateTime;

public abstract class LoggerFactory {
    protected abstract Logger build();

    public void log(String saida) {
        var hoje = LocalDateTime.now();
        var mensagem = String.format("[%s]: %s", hoje, saida);
        build().log(mensagem);
    }
}
