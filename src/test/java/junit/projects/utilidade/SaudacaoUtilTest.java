package junit.projects.utilidade;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {
    @Test
    @DisplayName("Deveria retornar bom dia")
    void saudarDia() {
        var saudacao = SaudacaoUtil.saudar(9);
        var saudacaoCorreta = "Bom dia";

        // JUnit
        assertEquals(saudacaoCorreta, saudacao, "Saudação incorreta!");

        // AssertJ
        Assertions
                .assertThat(saudacao)
                .withFailMessage("Saudação incorreta!")
                .isEqualTo(saudacaoCorreta);

        Assertions.assertThat(saudacao)
                .as("Validando se a saudação é %s", saudacaoCorreta)
                .isEqualTo(saudacaoCorreta);
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

        // JUnit
        var ex = assertThrows(IllegalArgumentException.class, () -> SaudacaoUtil.saudar(horaInvalida));
        assertEquals("Hora inválida", ex.getMessage());

        // AssertJ
        var e = Assertions.catchThrowableOfType(() -> SaudacaoUtil.saudar(horaInvalida), IllegalArgumentException.class);
        Assertions.assertThat(e).hasMessage("Hora inválida");

        Assertions.assertThatThrownBy(() -> SaudacaoUtil.saudar(horaInvalida))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Hora inválida");
    }

    @Test
    @DisplayName("Não deve lançar execeção com hora válida")
    void saudarNaoDeveLancarException() {
        var horaValida = 0;
        assertDoesNotThrow(() -> SaudacaoUtil.saudar(horaValida));
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 8, 9, 10, 11})
    void dadoHorarioMatinalEntaoDeveRetornarBomDia(int hora) {
        var saudacao = SaudacaoUtil.saudar(hora);
        assertEquals("Bom dia", saudacao, "Saudação incorreta!");
    }


}