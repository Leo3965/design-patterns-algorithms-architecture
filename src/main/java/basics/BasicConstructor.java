package basics;

import java.util.Objects;

public class BasicConstructor {

    class Product {

        static final int QUANTIDADE_ESTOQUE_INICIAL = 100;

        String nome;
        int quantidadeEstoque;

        Product() {
            this("Sem nome"); // encadeamento de construtures
        }

        Product(String nome) {
            this(nome, QUANTIDADE_ESTOQUE_INICIAL);
        }

        Product(String nome, int estoqueInicial) {
            Objects.requireNonNull(nome, "Nome é obrigatório");

            if (estoqueInicial < 0) {
                throw new IllegalArgumentException("Estoque inicial não pode ser negativo");
            }

            this.nome = nome;
            this.quantidadeEstoque = estoqueInicial;
        }

    }
}
