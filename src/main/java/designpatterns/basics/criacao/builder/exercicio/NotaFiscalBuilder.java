package designpatterns.basics.criacao.builder.exercicio;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class NotaFiscalBuilder {
    private NotaFiscal instancia;

    public NotaFiscalBuilder() {
        this.instancia = new NotaFiscal();
    }

    public NotaFiscalBuilder comNome(String nome) {
        instancia.setNome(nome);
        return this;
    }

    public NotaFiscalBuilder comDataEmissao(LocalDate data) {
        instancia.setDataEmissao(data);
        return this;
    }

    public NotaFiscalBuilder comQuantidade(int quantidade) {
        instancia.setQuantidade(quantidade);
        return this;
    }

    public NotaFiscalBuilder comValor(BigDecimal valor) {
        instancia.setValor(valor.setScale(2, RoundingMode.HALF_UP));
        return this;
    }

    public NotaFiscal construirFisica() {
        instancia.setTipo(Tipo.FISICA);
        return instancia;
    }

    public NotaFiscal construirJuridica() {
        instancia.setTipo(Tipo.JURIDICA);
        return instancia;
    }

}
