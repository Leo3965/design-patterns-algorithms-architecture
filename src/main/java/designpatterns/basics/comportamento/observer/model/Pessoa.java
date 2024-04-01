package designpatterns.basics.comportamento.observer.model;

import lombok.Data;

public class Pessoa {
    private Long codigo;
    private String nome;
    private String email;
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(Long codigo, String nome, String email, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
