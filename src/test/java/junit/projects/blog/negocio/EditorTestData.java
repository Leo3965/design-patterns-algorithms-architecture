package junit.projects.blog.negocio;

import junit.projects.blog.modelo.Editor;

import java.math.BigDecimal;

public class EditorTestData {

    private EditorTestData() {

    }

    public static Editor.Builder umEditorNovo() {
        return Editor.builder()
                .comNome("Leo")
                .comEmail("leo@email.com")
                .comValorPagoPorPalavra(BigDecimal.TEN)
                .comPremium(true);
    }

    public static Editor.Builder umEditorExistente() {
        return umEditorNovo().comId(1L);
    }

    public static Editor.Builder umEditorComIdInexistente() {
        return umEditorNovo().comId(99L);
    }

}
