package designpatterns.basics.criacao.abstractt.factory;

import designpatterns.basics.criacao.abstractt.factory.pag.seguro.AlertaDeRiscoException;
import designpatterns.basics.criacao.abstractt.factory.pag.seguro.CapturaNaoAutorizadaException;

import java.math.BigDecimal;

public class Pagamento {
    private final Operadora operadora;
    private final GestorDeRisco gestorDeRisco;

    public Pagamento(PagamentoAbstractFactory factory) {
        this.operadora = factory.criarOperadora();
        this.gestorDeRisco = factory.criarGestor();
    }

    public Long autorizar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
        this.operadora.capturar(cartao, valor);
        this.gestorDeRisco.avaliarRisco(cartao, valor);
        return this.operadora.confirmar();
    }
}
