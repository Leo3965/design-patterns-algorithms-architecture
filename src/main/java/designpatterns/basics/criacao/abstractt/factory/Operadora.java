package designpatterns.basics.criacao.abstractt.factory;

import designpatterns.basics.criacao.abstractt.factory.pag.seguro.CapturaNaoAutorizadaException;

import java.math.BigDecimal;

public interface Operadora {
    void capturar(String cartao, BigDecimal valor1) throws CapturaNaoAutorizadaException;

    Long confirmar();
}
