package model;

import java.time.LocalDate;

public class Categoria {
    private int id;
    private String nome;
    private String descricao;
    private int livroId; // Relacionamento com Livro
    private LocalDate dataCadastro;

    // Construtores
    public Categoria() {}

    public Categoria(String nome, String descricao, int livroId, LocalDate dataCadastro) {
        this.nome = nome;
        this.descricao = descricao;
        this.livroId = livroId;
        this.dataCadastro = dataCadastro;
    }
    
    //Construtor com nome, descrição,datalocal

    public Categoria(String nome, String descricao, LocalDate dataCadastro) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
    }
    
    
    //Construtor com nome
    public Categoria( String nome) {
    this.nome = nome;
}

    

    // Getters e Setters

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getLivroId() {
        return livroId;
    }

    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

}
