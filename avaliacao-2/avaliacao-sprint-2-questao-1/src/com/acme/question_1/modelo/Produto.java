package com.acme.question_1.modelo;

public class Produto {
    
    private final Integer id;
    private final String nome;
    private final String descricao;
    private final Integer quantidade;
    private final Double preco;

    public Produto(Integer id, String nome, String descricao, Integer quantidade, Double preco) {
        this.id=id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco=preco;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    
    public String getDescricao() {        
        return descricao;
    }

    public Integer getQuantidade() {     
        return quantidade;
    }
    
    public Double getPreco() {   
        return preco;
    }
    
}
