package designpatterns.basics.comportamento.observer.model;

public enum TipoLancamento {
    DESPESA("Despesa"),
    RECEITA("Receita");

    private final String descricao;

    TipoLancamento(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
