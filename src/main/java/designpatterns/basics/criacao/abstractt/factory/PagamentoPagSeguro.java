package designpatterns.basics.criacao.abstractt.factory;

import designpatterns.basics.criacao.abstractt.factory.pag.seguro.Cielo;
import designpatterns.basics.criacao.abstractt.factory.pag.seguro.FControl;

public class PagamentoPagSeguro implements PagamentoAbstractFactory {

    @Override
    public Operadora criarOperadora() {
        return new Cielo();
    }

    @Override
    public GestorDeRisco criarGestor() {
        return new FControl();
    }
}
