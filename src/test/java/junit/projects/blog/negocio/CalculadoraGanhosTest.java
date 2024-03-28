package junit.projects.blog.negocio;

import junit.projects.blog.modelo.Editor;
import junit.projects.blog.modelo.Post;
import junit.projects.blog.utilidade.ProcessadorTextoSimples;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CalculadoraGanhosTest {

    static CalculadoraGanhos CALCULADORA;
    Editor autor;
    Post post;

    @BeforeAll
    static void initAll() {
        CALCULADORA = new CalculadoraGanhos(new ProcessadorTextoSimples(), BigDecimal.TEN);
        System.out.println("Antes de todos os tests");
    }

    @BeforeEach
    void init() {
        autor = new Editor(1L, "Leonardo", "leonardo@email.com", BigDecimal.valueOf(5), true);
        post = new Post(1L, "Ecossistema Java", "O ecossistema do Java é muito maduro", autor, "ecossistema-java-abc123", null, false, false);
    }

    @Test
    void deveCalcularGanhos() {
        var ganhos = CALCULADORA.calcular(post);

        assertEquals(new BigDecimal(45), ganhos.getTotalGanho());
        assertEquals(7, ganhos.getQuantidadePalavras());
        assertEquals(autor.getValorPagoPorPalavra(), ganhos.getValorPagoPorPalavra());
    }

    @Test
    void deveCalcularGanhosSemPremium() {
        autor.setPremium(false);
        var ganhos = CALCULADORA.calcular(post);

        assertEquals(new BigDecimal(35), ganhos.getTotalGanho());
        assertEquals(7, ganhos.getQuantidadePalavras());
        assertEquals(autor.getValorPagoPorPalavra(), ganhos.getValorPagoPorPalavra());
    }

    @Test
    public void Dado_um_post_e_autor_premium_Quando_calcular_ganhos_Entao_deve_retornar_valor_com_bonus() {
        var ganhos = CALCULADORA.calcular(post);
        assertEquals(new BigDecimal("45"), ganhos.getTotalGanho());
    }

    @Test
    public void Dado_um_post_e_autor_Quando_calcular_ganhos_Entao_deve_retornar_quantidade_de_palavras_no_post() {
        var ganhos = CALCULADORA.calcular(post);
        assertEquals(7, ganhos.getQuantidadePalavras());
    }

    @Test
    public void Dado_um_post_e_autor_Quando_calcular_ganhos_Entao_deve_retornar_valor_pago_por_palavra_do_autor() {
        var ganhos = CALCULADORA.calcular(post);
        assertEquals(autor.getValorPagoPorPalavra(), ganhos.getValorPagoPorPalavra());
    }

    @Test
    public void Dado_um_post_e_autor_nao_premium_Quando_calcular_ganhos_Entao_deve_retornar_valor_sem_bonus() {
        autor.setPremium(false);
        var ganhos = CALCULADORA.calcular(post);
        assertEquals(new BigDecimal("35"), ganhos.getTotalGanho());
    }
}