package designpatterns.basics.criacao.abstractt.factory.exercicio.boleto;

import designpatterns.basics.criacao.abstractt.factory.exercicio.BoletoBancario;
import designpatterns.basics.criacao.abstractt.factory.exercicio.Produto;

import java.util.List;

public class BoletoBancoDoBrasil implements BoletoBancario {
    @Override
    public void emitirBoleto(List<Produto> produtos) {
        var builder = new StringBuilder();
        builder.append("----- Boleto Banco do Brasil -----\n");
        for (var p : produtos) {
            builder.append(String.format(
                    "Produto: [%s] | Preço: [%.2f] | Imposto: [%.2f]\n",
                    p.getNome(),
                    p.getValor(),
                    p.getImposto()
            ));
        }
        System.out.println(builder);
    }
}
