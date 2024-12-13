package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Categoria;

public class CategoriaDAO {

    public boolean incluirCategoria(Categoria categoria) {
        String sql = "INSERT INTO Categoria (categoria_nome, descricao, livroId, dataCadastro) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Preenchendo os valores da consulta
            stmt.setString(1, categoria.getNome());
            stmt.setString(2, categoria.getDescricao());
            stmt.setInt(3, categoria.getLivroId()); // Relacionamento com Livro
            stmt.setDate(4, java.sql.Date.valueOf(categoria.getDataCadastro())); // Data de cadastro

            // Executa o comando
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0; // Retorna true se a inserção foi bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

public Categoria buscarPorNome(String nome) {
    
    String sql = "SELECT * FROM Categoria WHERE categoria_nome = ?"; 
    
    try (Connection conn = Conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        // Preenchendo o parâmetro da consulta
        stmt.setString(1, nome);

        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                // Recuperando os dados da categoria
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setNome(rs.getString("categoria_nome")); 
                categoria.setDescricao(rs.getString("descricao"));
                categoria.setLivroId(rs.getInt("livroId"));
                categoria.setDataCadastro(rs.getDate("dataCadastro").toLocalDate());
                return categoria;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Retorna null se nenhuma categoria for encontrada
    return null;
}
}