package designpatterns.basics.criacao.builder.exercicio;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class NotaFiscal {
    private LocalDate dataEmissao;
    private String nome;
    private int quantidade;
    private BigDecimal valor;
    private Tipo tipo;

    @Override
    public String toString() {
        var formattedDate = dataEmissao.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        return "NotaFiscal{" +
                "dataEmissao=" + formattedDate +
                ", nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                ", tipo=" + tipo +
                '}';
    }

    public BigDecimal calcularImposto() {
        var calculadora = tipo.getCalculadoraDeImpostoFisica();
        return calculadora.calcular(valor);
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
