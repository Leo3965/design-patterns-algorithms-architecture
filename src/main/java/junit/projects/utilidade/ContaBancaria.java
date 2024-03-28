package junit.projects.utilidade;

import java.math.BigDecimal;

public class ContaBancaria {

    private BigDecimal saldo;

    public ContaBancaria(BigDecimal saldo) {
        if (saldo == null) {
            throw new IllegalArgumentException("saldo não pode ser nulo");
        }
        this.saldo = saldo;
    }

    public void saque(BigDecimal valor) {
        validaValor(valor);
        verificaSaldo(valor);
        this.saldo = this.saldo.subtract(valor);
    }

    private void verificaSaldo(BigDecimal valor) {
        if (saldo.compareTo(valor) < 0) {
            throw new RuntimeException("Saldo insuficiente");
        }
    }

    private void validaValor(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor não pode ser nulo e deve ser maior que zero");
        }
    }

    public void deposito(BigDecimal valor) {
        validaValor(valor);
        this.saldo = this.saldo.add(valor);
    }

    public BigDecimal saldo() {
        return this.saldo;
    }
}
