package designpatterns.basics.criacao.abstractt.factory;

import designpatterns.basics.criacao.abstractt.factory.pay.pal.ClearSale;
import designpatterns.basics.criacao.abstractt.factory.pay.pal.RedeCard;

public class PagamentoPayPal implements PagamentoAbstractFactory {
    @Override
    public Operadora criarOperadora() {
        return new RedeCard();
    }

    @Override
    public GestorDeRisco criarGestor() {
        return new ClearSale();
    }
}
