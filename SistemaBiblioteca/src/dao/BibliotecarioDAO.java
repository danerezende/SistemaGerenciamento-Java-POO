package dao;

import model.Bibliotecario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BibliotecarioDAO {
    public void inserirBibliotecario(Bibliotecario bibliotecario) {
        String sql = "INSERT INTO bibliotecario (nome, setor, turno, senha) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
        stmt.setString(1, bibliotecario.getNome());  // nome do bibliotecário
        stmt.setString(2, bibliotecario.getSetor());  // setor
        stmt.setString(3, bibliotecario.getTurno());  // turno
        stmt.setString(4, bibliotecario.getSenha());  // senha
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar bibliotecario", e);
        }
    }
}