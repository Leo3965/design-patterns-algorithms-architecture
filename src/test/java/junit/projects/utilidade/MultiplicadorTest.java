package junit.projects.utilidade;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

class MultiplicadorTest {

    @ParameterizedTest
    @EnumSource(value = Multiplicador.class, names = {"DOBRO", "TRIPLO"}) // se não passar names testa todos valores do enum
    void aplicarMultiplicador(Multiplicador multiplicador) {
        assertNotNull(multiplicador.aplicarMultiplicador(10.0));
    }

}