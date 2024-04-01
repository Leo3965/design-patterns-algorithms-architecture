package designpatterns.basics.estrutura.proxy.project1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ContatoCSVProxy implements Contatos {
    private ContatoCSV csv;
    private final List<String> nomeArquivos;

    public ContatoCSVProxy(String... arquivos) {
        nomeArquivos = new ArrayList<>(Arrays.asList(arquivos));
    }

    @Override
    public String buscarPor(String email) {
        Random random = new Random();
        String nomeContato = null;
        int quantidadeDeArquivos = nomeArquivos.size();

        for (int i = 0; i < quantidadeDeArquivos; i++) {
            int indiceParaPesquisa = random.nextInt(nomeArquivos.size());

            var nomeArq = nomeArquivos.remove(indiceParaPesquisa);
            csv = new ContatoCSV(nomeArq);
            nomeContato = csv.buscarPor(email);

            if (!nomeContato.isEmpty() || !nomeContato.isBlank()) break;
        }

        return nomeContato;
    }
}
