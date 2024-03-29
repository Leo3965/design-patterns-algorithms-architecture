package junit.tdd.projects.aerea;

import junit.tdd.projects.aerea.service.CalculadoraPrecoPassagem;
import junit.tdd.projects.aerea.service.PrecoPassagemGold;
import junit.tdd.projects.aerea.service.PrecoPassagemSilver;

public enum TipoPassageiro {
    GOLD(new PrecoPassagemGold()),
    SILVER(new PrecoPassagemSilver());

    CalculadoraPrecoPassagem calculadora;

    TipoPassageiro(CalculadoraPrecoPassagem calculadora) {
        this.calculadora = calculadora;
    }

    public CalculadoraPrecoPassagem getCalculadora() {
        return calculadora;
    }
}
