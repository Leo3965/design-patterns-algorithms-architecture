package junit.tdd.projects.aerea.service;

import junit.tdd.projects.aerea.Voo;

public class PrecoPassagemSilver implements CalculadoraPrecoPassagem {
    @Override
    public double calcular(Voo voo) {
        if (voo.getPreco() > 700) {
            return calcularValorAcimaDoLimite(voo);
        }
        return calcularValorAbaixoDoLimite(voo);
    }

    private double calcularValorAbaixoDoLimite(Voo voo) {
        return voo.getPreco() * 0.94;
    }

    private double calcularValorAcimaDoLimite(Voo voo) {
        return voo.getPreco() * 0.9;
    }
}
