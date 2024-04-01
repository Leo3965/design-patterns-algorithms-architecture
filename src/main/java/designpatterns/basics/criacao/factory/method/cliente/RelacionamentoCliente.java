package designpatterns.basics.criacao.factory.method.cliente;

import designpatterns.basics.criacao.factory.method.maladireta.MalaDiretaABS;

import javax.swing.*;

public class RelacionamentoCliente {

    public static void main(String[] args) {
        MalaDiretaABS malaDireta = new MalaDiretaCSV("contatos.csv");
        String mensagem = JOptionPane.showInputDialog(null, "Digite a mensagem do e-mail:");

        boolean status = malaDireta.enviarEmail(mensagem);

        JOptionPane.showConfirmDialog(null, "E-mails enviados: " + status);
    }

}
