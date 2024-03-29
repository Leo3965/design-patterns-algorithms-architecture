package junit.tdd.projects.aerea.service;

import junit.tdd.projects.aerea.Passageiro;
import junit.tdd.projects.aerea.Voo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

class PrecoPassagemServiceTest {

    PrecoPassagemService service;

    @BeforeEach
    void before() {
        service = new PrecoPassagemService();
    }


}