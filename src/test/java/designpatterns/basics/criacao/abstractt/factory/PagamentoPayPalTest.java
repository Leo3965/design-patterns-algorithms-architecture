package designpatterns.basics.criacao.abstractt.factory;

import designpatterns.basics.criacao.abstractt.factory.pag.seguro.AlertaDeRiscoException;
import designpatterns.basics.criacao.abstractt.factory.pag.seguro.CapturaNaoAutorizadaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PagamentoPayPalTest {
    private Pagamento pagamento;

    @BeforeEach
    void init() {
        pagamento = new Pagamento(new PagamentoPayPal());
    }

    @Test
    void deveriaAutorizarVenda() throws AlertaDeRiscoException, CapturaNaoAutorizadaException {
        Long codigo = pagamento.autorizar("8888.2222", new BigDecimal("200"));
        assertNotNull(codigo);
    }

    @Test
    void deveNegarCapturaCartaoInvalido() {
        assertThrows(
                CapturaNaoAutorizadaException.class,
                () -> pagamento.autorizar("2222.5555", new BigDecimal("2000"))
        );
    }

    @Test
    void deveGerarAlertaDeRisco() {
        assertThrows(
                AlertaDeRiscoException.class,
                () -> pagamento.autorizar("1111.7777", new BigDecimal("5500"))
        );
    }
}