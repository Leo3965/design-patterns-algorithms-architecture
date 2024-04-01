package designpatterns.basics.criacao.factory.method.cliente;

import designpatterns.basics.criacao.factory.method.contato.ContatosI;
import designpatterns.basics.criacao.factory.method.maladireta.MalaDiretaABS;

public class MalaDiretaCSV extends MalaDiretaABS {
    private String nomeArquivo;

    public MalaDiretaCSV(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    protected ContatosI criarContatos() {
        return new ContatoCSV(nomeArquivo);
    }

}
