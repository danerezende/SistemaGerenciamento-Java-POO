package dao;

import model.Livro;
import model.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LivroDAO {

// Método para listar todos os livros no banco de dados com o nome da categoria
public List<Livro> listar() {
    List<Livro> livros = new ArrayList<>();
    String sql = "SELECT l.id, l.titulo, l.autor, l.categoria_nome, l.isbn, l.anoPublicacao, l.disponivel " +
            "FROM Livro l";

    try (Connection conn = Conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            // Criando o livro e a categoria com o nome
            Livro livro = new Livro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    new Categoria(rs.getString("categoria_nome")), // Criando a categoria apenas com o nome
                    rs.getString("isbn"),
                    rs.getInt("anoPublicacao"),
                    rs.getBoolean("disponivel")
            );
            livros.add(livro);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return livros;
}

// Excluir livro do banco
public void excluir(int id) {
    String sql = "DELETE FROM Livro WHERE id = ?";
    try (Connection conn = Conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// Verificar se a categoria existe na tabela
private boolean verificarCategoriaExistente(String categoriaNome) {
    String sql = "SELECT 1 FROM categoria WHERE categoria_nome = ?";
    try (Connection conn = Conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, categoriaNome);
        ResultSet rs = stmt.executeQuery();
        return rs.next(); // Se encontrar algum resultado, a categoria existe
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

// Atualizar livro no banco com verificação da categoria
public boolean atualizar(Livro livro) {
    // Verifica se a categoria do livro existe
    if (livro.getCategoria() != null && verificarCategoriaExistente(livro.getCategoria().getNome())) {
        int categoriaId = livro.getCategoria().getId(); // Obtendo o id da categoria

        String sql = "UPDATE Livro SET titulo = ?, autor = ?, categoria_nome = ?, isbn = ?, anoPublicacao = ?, disponivel = ? WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setString(3, livro.getCategoria().getNome()); // Categoria nome para chave estrangeira
            stmt.setString(4, livro.getIsbn());
            stmt.setInt(5, livro.getAnoPublicacao());
            stmt.setBoolean(6, livro.isDisponivel());
            stmt.setInt(7, livro.getId());

            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0; // Retorna true se a atualização foi bem-sucedida
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    } else {
        System.out.println("Erro: A categoria do livro não existe.");
        return false;
    }
}

}