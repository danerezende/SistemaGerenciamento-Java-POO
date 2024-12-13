package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Emprestimo {
    private int id;
    private int livroId;
    private int usuarioId;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private boolean disponivel;

    // Construtor com String para as datas
public Emprestimo(int id, int livroId, int usuarioId, Date dataEmprestimo, Date dataDevolucao, boolean disponivel) {
    this.id = id;
    this.livroId = livroId;
    this.usuarioId = usuarioId;
    this.dataEmprestimo = dataEmprestimo;
    this.dataDevolucao = dataDevolucao;
    this.disponivel = disponivel;
}


    // Getters e Setters
    public int getId() { return id; }
    public int getLivroId() { return livroId; }
    public int getUsuarioId() { return usuarioId; }
    public Date getDataEmprestimo() { return dataEmprestimo; }
    public Date getDataDevolucao() { return dataDevolucao; }
    public boolean isDisponivel() { return disponivel; }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

