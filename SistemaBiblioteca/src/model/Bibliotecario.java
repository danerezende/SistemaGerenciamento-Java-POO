//Classe Bibliotecario herda usuario (gerenciamento de empréstimos e devoluções)
package model;

import java.util.Date;

public class Bibliotecario extends Usuario {
    private String setor;
    private String turno;
    private String senha;

    public Bibliotecario(String nome, String setor, String turno, String senha) {
        super(nome);
        this.setor = setor;
        this.turno = turno;
        this.senha = senha;
    }

    public Bibliotecario(String nome, String senha) {
        super(nome);
        this.senha = senha;
    }
    
    




    // Getters e Setters
    public String getSetor() { return setor; }
    public void setSetor(String setor) { this.setor = setor; }
    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }
    public String getSenha() {return senha;}
    public void setSenha(String senha) {this.senha = senha;}
}
