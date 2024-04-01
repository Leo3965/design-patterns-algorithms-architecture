package designpatterns.basics.criacao.builder.exercicio;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

class NotaFiscalTest {

    @Test
    void deveriaCriarJuridica() {
        var nota = new NotaFiscalBuilder()
                .comDataEmissao(LocalDate.now())
                .comNome("Leonardo")
                .comQuantidade(4)
                .comValor(BigDecimal.valueOf(40))
                .construirJuridica();
        System.out.println(nota);
        Assertions.assertThat(nota.calcularImposto()).isEqualTo(
                BigDecimal.valueOf(1.6).setScale(2, RoundingMode.HALF_UP)
        );
    }

    @Test
    void deveriaCriarFisica() {
        var nota = new NotaFiscalBuilder()
                .comDataEmissao(LocalDate.now())
                .comNome("Leonardo")
                .comQuantidade(4)
                .comValor(BigDecimal.valueOf(40))
                .construirFisica();

        System.out.println(nota);

        Assertions.assertThat(nota.calcularImposto()).isEqualTo(
                BigDecimal.valueOf(2.8).setScale(4, RoundingMode.HALF_UP)
        );
    }

}