package designpatterns.basics.estrutura.proxy.project1;

import au.com.bytecode.opencsv.CSVReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContatoCSV implements Contatos {
    private final List<Contato> contatos;

    public ContatoCSV(String... arquivos) {
        System.out.println("Carregando arquivos: " + Arrays.toString(arquivos));
        this.contatos = new ArrayList<>();
        for (var arq : arquivos) {
            carregaContatos(arq);
        }
    }

    private void carregaContatos(String nomeArquivo) {
        CSVReader csvReader = null;
        try {
            URI uri = this.getClass().getResource("/" + nomeArquivo).toURI();
            File arquivoCsv = new File(uri);
            FileReader fileReader = new FileReader(arquivoCsv);
            csvReader = new CSVReader(fileReader);
            String[] nextLine;

            while ((nextLine = csvReader.readNext()) != null) {
                contatos.add(new Contato(nextLine[0].trim(), nextLine[1].trim()));
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro lendo arquivo csv", e);
        } finally {
            try {
                csvReader.close();
            } catch (IOException ignored) {
            }
        }
    }

    @Override
    public String buscarPor(String email) {
        var contato = contatos.stream()
                .filter(c -> c.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(new Contato("", ""));

        return contato.getNome();
    }

}
