package designpatterns.basics.criacao.abstractt.factory.exercicio;

import designpatterns.basics.criacao.abstractt.factory.exercicio.boleto.BoletoBancoDoBrasil;
import designpatterns.basics.criacao.abstractt.factory.exercicio.boleto.BoletoCaixaEconomica;
import designpatterns.basics.criacao.abstractt.factory.exercicio.nota.NotaFiscalMinasGerais;
import designpatterns.basics.criacao.abstractt.factory.exercicio.nota.NotaFiscalSaoPaulo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmissaoNotaFiscalTest {

    private EmissaoNotaFiscal notaFiscal;

    @BeforeEach
    void before() {
        notaFiscal = new EmissaoNotaFiscal(new BoletoCaixaEconomica(), new NotaFiscalSaoPaulo());
    }

    @Test
    void deveriaCalcularImpostoSP() {
        var skate = new Produto("Skate", 100);
        var sapato = new Produto("Sapato", 140);

        notaFiscal.emitir(List.of(
                skate,
                sapato
        ));

        assertEquals(10, skate.getImposto());
        assertEquals(14, sapato.getImposto());
    }

    @Test
    void deveriaCalcularImpostoMG() {
        var skate = new Produto("Skate", 100);
        var sapato = new Produto("Sapato", 140);

        notaFiscal = new EmissaoNotaFiscal(new BoletoBancoDoBrasil(), new NotaFiscalMinasGerais());
        notaFiscal.emitir(List.of(
                skate,
                sapato
        ));

        assertEquals(7, skate.getImposto(), 0.1);
        assertEquals(9.8, sapato.getImposto(), 0.1);
    }
}