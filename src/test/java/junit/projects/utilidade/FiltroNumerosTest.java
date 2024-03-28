package junit.projects.utilidade;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

@DisplayNameGeneration(DisplayNameGenerator.Simple.class)
class FiltroNumerosTest {

    @Test
    // given, when, then
    void dadoUmaListaDeNumerosQuandoFiltrarPorParesEntaoDeveRetornarApenasNumerosPares() {
        var numeros = Arrays.asList(1, 2, 3, 4);
        var pares = Arrays.asList(2, 4);
        var resultado = FiltroNumeros.numerosPares(numeros);
        assertIterableEquals(pares, resultado); // utiliza método equals
    }

    @Test
    void dadoUmaListaDeNumerosQuandoFiltrarPorImparesEntaoDeveRetornarApenasNumerosPares() {
        var numeros = Arrays.asList(1, 2, 3, 4);
        var impares = Arrays.asList(1, 3);
        var resultado = FiltroNumeros.numerosImpares(numeros);
        assertIterableEquals(impares, resultado);
    }
}