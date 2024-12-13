package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Leitor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Micro
 */
public class LeitorDAO {
    public void inserirLeitor(Leitor leitor) {
        String sql = "INSERT INTO leitor (nome, dataDevolucao, multasPendentes) VALUES (?, ?, ?)";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            Date dataDevolucao = leitor.getDataDevolucao();
        if (dataDevolucao == null) {
            dataDevolucao = new Date();  // ou qualquer valor padrão que você queira
        }
            
        stmt.setString(1, leitor.getNome());  // nome do bibliotecário
        stmt.setDate(2, new java.sql.Date(dataDevolucao.getTime()));  // data
        stmt.setDouble(3, leitor.calcularTotalMultas());  // multa
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar leitor", e);
        }
    }
    
     public void atualizarDataDevolucaoPorNome(int idUsuario, Date novaDataDevolucao) {
        // SQL para atualizar a data de devolução, baseado no nome do usuário na tabela "usuario"
        String sql = "UPDATE leitor l " +
             "JOIN usuario u ON u.nome = l.nome " +
             "SET l.dataDevolucao = ? " +
             "WHERE u.id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Definir os parâmetros da consulta SQL
            stmt.setDate(1, new java.sql.Date(novaDataDevolucao.getTime())); // Nova data de devolução
            stmt.setInt(2, idUsuario); // ID do usuário (referencia na tabela "usuario")
            

            // Executar a atualização no banco de dados
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Data de devolução do leitor atualizada com sucesso!");
            } else {
                System.out.println("Leitor não encontrado para atualizar a data.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erro ao atualizar data de devolução.");
        }
    }
}
