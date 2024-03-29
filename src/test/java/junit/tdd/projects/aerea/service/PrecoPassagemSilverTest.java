package junit.tdd.projects.aerea.service;

import junit.tdd.projects.aerea.Voo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PrecoPassagemSilverTest {
    private PrecoPassagemSilver silver = new PrecoPassagemSilver();

    @Test
    void deveCalcularPrecoParaPassageiroSilverComValorAbaixoDoLimite() {
        Voo voo = new Voo("SP", "RJ", 100);
        double valor = silver.calcular(voo);
        Assertions.assertThat(valor).isEqualTo(94);
    }

    @Test
    void deveCalcularValorPassagemParaPassageiroSilverComValorAcimaDoLimite() {
        Voo voo = new Voo("SP", "RJ", 800);
        double valor = silver.calcular(voo);
        Assertions.assertThat(valor).isEqualTo(720);
    }
}