//O Leitor herda de Usuario, adicionado referência a multas pendentes
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Leitor extends Usuario {
    private Date dataDevolucao;
    private List<Multa> multasPendentes = new ArrayList<>();

    public Leitor(String nome, Date dataDevolucao, List<Multa> multasPendentes) {
        super(nome);
        this.dataDevolucao = dataDevolucao;
        this.multasPendentes = multasPendentes;
    }

    public Leitor(String nome,Date dataDevolucao) {
        super(nome);
        this.dataDevolucao = dataDevolucao;
    }
    

    // Adiciona uma multa à lista de multas pendentes
    public void adicionarMulta(Multa multa) {
        multasPendentes.add(multa);
    }

    // Getters e Setters
    public Date getDataDevolucao() { return dataDevolucao; }
    public void setDataDevolucao(Date dataDevolucao) { this.dataDevolucao = dataDevolucao; }
    public List<Multa> getMultasPendentes() { return multasPendentes; }
    
    public double calcularTotalMultas() {
        double soma = 0.0;
        for (Multa multa : multasPendentes) {
            soma += multa.getValor(); // Obtém o valor de cada multa e soma
        }
        return soma;
    }
}


