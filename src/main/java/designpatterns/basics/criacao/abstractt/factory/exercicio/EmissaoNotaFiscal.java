package designpatterns.basics.criacao.abstractt.factory.exercicio;

import java.util.List;

public class EmissaoNotaFiscal {
    private final BoletoBancario boletoBancario;
    private final NotaFiscalEletronica nfe;

    public EmissaoNotaFiscal(BoletoBancario boletoBancario, NotaFiscalEletronica nfe) {
        this.boletoBancario = boletoBancario;
        this.nfe = nfe;
    }

    public void emitir(List<Produto> produtos) {
        produtos.forEach(this::calcularImpostoProduto);
        boletoBancario.emitirBoleto(produtos);
    }

    private void calcularImpostoProduto(Produto p) {
        p.setImposto(nfe.calcularImposto(p.getValor()));
    }
}
