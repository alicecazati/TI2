package com.example.model;

public class Produto {
    private int id;
    private String nome;
    private Float preco;
    private String contato;

    public Produto() {

    }

    public Produto(int id, String nome, Float preco, String contato) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.contato = contato;
    }

    public Produto(String nome, Float preco, String contato) {
        this.nome = nome;
        this.preco = preco;
        this.contato = contato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", contato=" + contato + "]";
    }

}
