package junit.tdd.projects.pedido;

public class Item {
    private String produto;
    private double valor;
    private int quantidade;

    public Item(String produto, double valor, int quantidade) {
        this.produto = produto;
        this.valor = valor;
        this. quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
