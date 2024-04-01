package designpatterns.basics.criacao.abstractt.factory.pag.seguro;

import designpatterns.basics.criacao.abstractt.factory.Operadora;

import java.math.BigDecimal;

public class Cielo implements Operadora {
    private Long codigoConformacao = -1L;

    @Override
    public void capturar(String cartao, BigDecimal valor1) throws CapturaNaoAutorizadaException {
        if (cartao.startsWith("5555")) {
            throw new CapturaNaoAutorizadaException("Número do cartão inválido");
        }

        this.codigoConformacao = (long) (Math.random() * 1000);
    }

    @Override
    public Long confirmar() {
        System.out.println("Fazendo o débito na conta do cliente via Cielo");
        return codigoConformacao;
    }
}
