package designpatterns.basics.criacao.abstractt.factory;

import designpatterns.basics.criacao.abstractt.factory.pag.seguro.AlertaDeRiscoException;
import designpatterns.basics.criacao.abstractt.factory.pag.seguro.CapturaNaoAutorizadaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PagamentoPagSeguroTest {

    private Pagamento pagamento;

    @BeforeEach
    void init() {
        pagamento = new Pagamento(new PagamentoPagSeguro());
    }

    @Test
    void deveriaAutorizarVenda() throws AlertaDeRiscoException, CapturaNaoAutorizadaException {
        Long codigo = pagamento.autorizar("2222.2222", new BigDecimal("200"));
        assertNotNull(codigo);
    }

    @Test
    void deveNegarCapturaCartaoInvalido() {
        assertThrows(
                CapturaNaoAutorizadaException.class,
                () -> pagamento.autorizar("5555.2222", new BigDecimal("2000"))
        );
    }

    @Test
    void deveGerarAlertaDeRisco() {
        assertThrows(
                AlertaDeRiscoException.class,
                () -> pagamento.autorizar("7777.2222", new BigDecimal("5500"))
        );
    }
}