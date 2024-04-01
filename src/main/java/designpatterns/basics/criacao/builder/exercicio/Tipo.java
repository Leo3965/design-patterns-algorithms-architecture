package designpatterns.basics.criacao.builder.exercicio;

public enum Tipo {
    FISICA(new CalculadoraDeImpostoFisica()),
    JURIDICA(new CalculadoraDeImpostoJuridica());

    private final CalculadoraDeImposto calculadoraDeImpostoFisica;

    Tipo(CalculadoraDeImposto calculadoraDeImpostoFisica) {
        this.calculadoraDeImpostoFisica = calculadoraDeImpostoFisica;
    }

    public CalculadoraDeImposto getCalculadoraDeImpostoFisica() {
        return calculadoraDeImpostoFisica;
    }
}
