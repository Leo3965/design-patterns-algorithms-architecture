package designpatterns.basics.criacao.factory.method.cliente;


import designpatterns.basics.criacao.factory.method.maladireta.MalaDiretaABS;

import javax.swing.*;

public class NovoClienteCadastrado {

    public static void main(String[] args) {
        MalaDiretaABS malaDireta = new MalaDiretaXML("contatos.xml");
        String mensagem = JOptionPane.showInputDialog(null, "Informe a mensagem de novo cliente:");
        boolean status = malaDireta.enviarEmail(mensagem);
        JOptionPane.showMessageDialog(null, "E-mails enviados: " + status);
    }

}
