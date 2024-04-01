package designpatterns.basics.criacao.abstractt.factory.pay.pal;

import designpatterns.basics.criacao.abstractt.factory.Operadora;
import designpatterns.basics.criacao.abstractt.factory.pag.seguro.CapturaNaoAutorizadaException;

import java.math.BigDecimal;

public class RedeCard implements Operadora {
    private Long codigoConfirmacao = -1L;

    @Override
    public void capturar(String cartao, BigDecimal valor1) throws CapturaNaoAutorizadaException {
        if (cartao.startsWith("2222")) {
            throw new CapturaNaoAutorizadaException("Cartão inválido");
        }
    }

    @Override
    public Long confirmar() {
        System.out.println("Fazendo o débito na conta do cliente via RedeCard");
        return this.codigoConfirmacao;
    }
}
