package designpatterns.basics.criacao.abstractt.factory.exercicio.nota;

import designpatterns.basics.criacao.abstractt.factory.exercicio.NotaFiscalEletronica;

public class NotaFiscalSaoPaulo implements NotaFiscalEletronica {
    private final double IMPOSTO_SP = 0.1;
    @Override
    public double calcularImposto(double valor) {
        return valor * IMPOSTO_SP;
    }
}
