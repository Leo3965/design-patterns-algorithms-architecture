package designpatterns.basics.estrutura.proxy.project1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuscarPorContatoTest {

    @Test
    void deveriaRetornarNomeDoContato() {
        Contatos csv = new ContatoCSVProxy("contatos.csv", "contatos2.csv");
        String nome = csv.buscarPor("leonardo@email.com");
        assertEquals("Leonardo", nome);
    }

}