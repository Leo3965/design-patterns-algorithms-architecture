package designpatterns.basics.criacao.abstractt.factory.exercicio.nota;

import designpatterns.basics.criacao.abstractt.factory.exercicio.NotaFiscalEletronica;

public class NotaFiscalMinasGerais implements NotaFiscalEletronica {
    private final double IMPOSTO_MG = 0.07;
    @Override
    public double calcularImposto(double valor) {
        return valor * IMPOSTO_MG;
    }
}
