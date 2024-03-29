package junit.tdd.projects.aerea.service;

import junit.tdd.projects.aerea.Voo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PrecoPassagemGoldTest {

    private PrecoPassagemGold gold = new PrecoPassagemGold();

    @Test
    void deveCalcularPrecoParaPassageiroGoldComValorAbaixoDoLimite() {
        Voo voo = new Voo("SP", "RJ", 100);
        double valor = gold.calcular(voo);
        Assertions.assertThat(valor).isEqualTo(90);
    }

    @Test
    void deveCalcularValorPassagemParaPassageiroGoldComValorAcimaDoLimite() {
        Voo voo = new Voo("SP", "RJ", 600);
        double valor = gold.calcular(voo);
        Assertions.assertThat(valor).isEqualTo(510);
    }

}