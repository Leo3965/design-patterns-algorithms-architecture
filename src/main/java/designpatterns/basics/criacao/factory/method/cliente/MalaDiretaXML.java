package designpatterns.basics.criacao.factory.method.cliente;

import designpatterns.basics.criacao.factory.method.contato.ContatosI;
import designpatterns.basics.criacao.factory.method.maladireta.MalaDiretaABS;

public class MalaDiretaXML extends MalaDiretaABS {

    private String nomeArquivo;

    public MalaDiretaXML(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    protected ContatosI criarContatos() {
        return new ContatosXML(nomeArquivo);
    }

}
