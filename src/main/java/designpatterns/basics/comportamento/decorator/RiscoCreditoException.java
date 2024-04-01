package designpatterns.basics.comportamento.decorator;

public class RiscoCreditoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RiscoCreditoException(String msg) {
        super(msg);
    }

}