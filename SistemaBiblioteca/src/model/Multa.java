package model;

import java.util.Date;

public class Multa {
    private int id;
    private int usuarioId;
    private double valor;
    private Date dataMulta;
    private String status; // Status pode ser "pendente" ou "pago"

    // Construtor completo
    public Multa(int id, int usuarioId, double valor, Date dataMulta, String status) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.valor = valor;
        this.dataMulta = dataMulta;
        this.status = status;
    }

    // Construtor alternativo para inicializar sem ID e com status padrão
    public Multa(int usuarioId, double valor, Date dataMulta) {
        this.usuarioId = usuarioId;
        this.valor = valor;
        this.dataMulta = dataMulta;
        this.status = "pendente"; // Status padrão
    }


    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getUsuarioId() { return usuarioId; }
    public void setUsuarioId(int usuarioId) { this.usuarioId = usuarioId; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public Date getDataMulta() { return dataMulta; }
    public void setDataMulta(Date dataMulta) { this.dataMulta = dataMulta; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
