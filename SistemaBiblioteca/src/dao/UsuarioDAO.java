package dao;

import model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class UsuarioDAO {
    public void cadastrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, email, telefone, dataCadastro, tipo) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getTelefone());
            stmt.setString(4, new SimpleDateFormat("yyyy/MM/dd").format(usuario.getDataCadastro()));
            stmt.setString(5, usuario.getTipo());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar usuário", e);
        }
    }
    
    public int buscarIdUsuarioPorEmail(String email) {
    String sql = "SELECT id FROM usuario WHERE email = ?";
    System.out.println("email:" + email);
    int idUsuario = -1;

    try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, email);

        var rs = stmt.executeQuery();
        if (rs.next()) {
            idUsuario = rs.getInt("id");
        }
    } catch (Exception e) {
        throw new RuntimeException("Erro ao buscar ID do usuário", e);
    }

    return idUsuario;
}
}
