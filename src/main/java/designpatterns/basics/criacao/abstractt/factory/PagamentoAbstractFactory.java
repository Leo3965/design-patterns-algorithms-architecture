package designpatterns.basics.criacao.abstractt.factory;

public interface PagamentoAbstractFactory {
    Operadora criarOperadora();
    GestorDeRisco criarGestor();
}
