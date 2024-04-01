package designpatterns.basics.criacao.abstractt.factory;

import designpatterns.basics.criacao.abstractt.factory.pag.seguro.AlertaDeRiscoException;

import java.math.BigDecimal;

public interface GestorDeRisco {
    void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException;
}
