package designpatterns.basics.criacao.factory.method.maladireta;

import designpatterns.basics.criacao.factory.method.contato.Contato;
import designpatterns.basics.criacao.factory.method.contato.ContatosI;

import java.util.List;

public abstract class MalaDiretaABS {
    protected abstract ContatosI criarContatos();

    public final boolean enviarEmail(String mensagem) {
        List<Contato> contatos = criarContatos().todos();

        System.out.println("Conectando no servidor SMTP...");
        System.out.println("Mensagem a ser enviada: " + mensagem);
        System.out.println();

        for (Contato contato : contatos) {
            System.out.println("From: <contato@algaworks.com>");
            System.out.printf("To: [%s] <%s>\n", contato.getNome(), contato.getEmail());
            System.out.println(mensagem);
            System.out.println();
        }

        return true;
    }

}
