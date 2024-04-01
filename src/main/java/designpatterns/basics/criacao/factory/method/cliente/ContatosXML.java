package designpatterns.basics.criacao.factory.method.cliente;

import com.thoughtworks.xstream.XStream;
import designpatterns.basics.criacao.factory.method.contato.Contato;
import designpatterns.basics.criacao.factory.method.contato.ContatosI;

import java.net.URL;
import java.util.List;

public class ContatosXML implements ContatosI {

    private String nomeArquivo;

    public ContatosXML(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contato> todos() {
        XStream xstream = new XStream();
        xstream.alias("contatos", List.class);
        xstream.alias("contato", Contato.class);

        URL arquivo = this.getClass().getResource("/" + nomeArquivo);
        return (List<Contato>) xstream.fromXML(arquivo);
    }

}
