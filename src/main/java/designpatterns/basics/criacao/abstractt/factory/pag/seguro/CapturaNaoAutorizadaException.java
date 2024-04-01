package designpatterns.basics.criacao.abstractt.factory.pag.seguro;

public class CapturaNaoAutorizadaException extends Exception {
    public CapturaNaoAutorizadaException(String msg) {
        super(msg);
    }

    public CapturaNaoAutorizadaException() {

    }
}
