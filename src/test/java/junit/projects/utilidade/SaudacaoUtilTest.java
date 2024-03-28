package junit.projects.utilidade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {
    @Test
    @DisplayName("Deveria retornar bom dia")
    void saudarDia() {
        var saudacao = SaudacaoUtil.saudar(9);
        assertEquals("Bom dia", saudacao, "Saudação incorreta!");
    }

    @Test
    @DisplayName("Deveria retornar bom tarde")
    void saudarTarde() {
        var saudacao = SaudacaoUtil.saudar(13);
        assertEquals("Boa tarde", saudacao, "Saudação incorreta!");
    }

    @Test
    @DisplayName("Deveria retornar boa noite")
    void saudarNoite() {
        var horaNoturnaValida1 = 20;
        var horaNoturnaValida2 = 4;
        assertAll("Asserção de saudação noturna",
                () -> assertEquals("Boa noite", SaudacaoUtil.saudar(horaNoturnaValida1), "Saudação incorreta!"),
                () -> assertEquals("Boa noite", SaudacaoUtil.saudar(horaNoturnaValida2))
        );
    }

    @Test
    @DisplayName("Deveria retornar exception com horas inválidas")
    void saudarDeveriaRetornarException() {
        var horaInvalida = -10;
        var ex = assertThrows(IllegalArgumentException.class, () -> SaudacaoUtil.saudar(horaInvalida));
        assertEquals("Hora inválida", ex.getMessage());
    }

    @Test
    @DisplayName("Não deve lançar execeção com hora válida")
    void saudarNaoDeveLancarException() {
        var horaValida = 0;
        assertDoesNotThrow(() -> SaudacaoUtil.saudar(horaValida));
    }
}