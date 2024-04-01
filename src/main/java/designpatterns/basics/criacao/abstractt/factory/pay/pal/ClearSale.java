package designpatterns.basics.criacao.abstractt.factory.pay.pal;

import designpatterns.basics.criacao.abstractt.factory.GestorDeRisco;
import designpatterns.basics.criacao.abstractt.factory.pag.seguro.AlertaDeRiscoException;

import java.math.BigDecimal;

public class ClearSale implements GestorDeRisco {
    @Override
    public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException {
        if (cartao.startsWith("1111")) {
            throw new AlertaDeRiscoException("Risco no cartão");
        }
    }
}
