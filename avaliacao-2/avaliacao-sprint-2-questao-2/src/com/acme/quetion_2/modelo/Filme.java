package com.acme.quetion_2.modelo;

public class Filme {
    
    private Integer id;
    private String nome;
    private String descricao;
    private Integer ano;
    
    public Filme(Integer id, String nome, String descricao, Integer ano) {
        this.id=id;
        this.nome=nome;
        this.descricao=descricao;
        this.ano=ano;
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

    public Integer getAno() {     
        return ano;
    }
    
    @Override
    public String toString() {
        return String.format("Nome: %s\nDescricão: %s\nAno: %d", this.nome, this.descricao, this.ano);
    }
    
}
