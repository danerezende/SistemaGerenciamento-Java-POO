package dao;

import java.sql.*;
import model.Bibliotecario;

public class LoginDAO {

    // Método para validar o login do usuário
    public boolean validarLogin(String nome, String senha) {
        // Definindo a consulta SQL para verificar se o nome e a senha coincidem no banco de dados
        String sql = "SELECT * FROM bibliotecario WHERE nome = ? AND senha = ?";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Definindo os parâmetros para a consulta
            stmt.setString(1, nome);
            stmt.setString(2, senha);

            // Executando a consulta e verificando se um resultado foi encontrado
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Se um registro foi encontrado, o login é válido
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Se não encontrou nenhum registro, retorna falso (login inválido)
        return false;
    }
}