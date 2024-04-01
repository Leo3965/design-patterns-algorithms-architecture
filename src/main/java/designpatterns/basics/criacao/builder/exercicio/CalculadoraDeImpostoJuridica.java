package designpatterns.basics.criacao.builder.exercicio;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculadoraDeImpostoJuridica implements CalculadoraDeImposto {
    @Override
    public BigDecimal calcular(BigDecimal valor) {
        return valor.multiply(BigDecimal.valueOf(0.04))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
