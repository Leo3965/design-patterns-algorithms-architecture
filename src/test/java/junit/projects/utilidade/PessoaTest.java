package junit.projects.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PessoaTest {
    @Test
    void assercaoAgrupada() {
        Pessoa pessoa = new Pessoa("Leonardo", "Freitas");
        assertAll("Asserções de pessoa",
                () -> assertEquals("Leonardo", pessoa.getNome()),
                () -> assertEquals("Freitas", pessoa.getSobrenome())
        );
    }
}