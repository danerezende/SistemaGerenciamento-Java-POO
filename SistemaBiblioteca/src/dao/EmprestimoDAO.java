package dao;

import model.Emprestimo;
import java.sql.*;

public class EmprestimoDAO {

public boolean verificarDisponibilidadeLivro(int livroId) {
    String sql = "SELECT disponivel FROM livro WHERE id = ?";

    try (Connection conn = Conexao.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, livroId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            boolean disponivel = rs.getBoolean("disponivel");
            System.out.println("Disponibilidade consultada para livro ID " + livroId + ": " + disponivel);
            return disponivel;
        } else {
            System.out.println("Livro com ID " + livroId + " não encontrado no banco.");
            throw new RuntimeException("Livro não encontrado no sistema.");
        }

    } catch (SQLException e) {
        throw new RuntimeException("Erro ao verificar disponibilidade do livro", e);
    }
}

    // Método para inserir um novo empréstimo
        public void inserirEmprestimo(Emprestimo emprestimo) {
            if (!verificarDisponibilidadeLivro(emprestimo.getLivroId())) {
                throw new RuntimeException("O livro está indisponível para empréstimo.");
            }

            String sqlEmprestimo = "INSERT INTO emprestimo (livroId, usuarioId, dataEmprestimo, dataDevolucao, disponivel) VALUES (?, ?, ?, ?, ?)";
            String sqlLivro = "UPDATE livro SET disponivel = false WHERE id = ?";

            try (Connection conn = Conexao.getConnection();
                 PreparedStatement stmtEmprestimo = conn.prepareStatement(sqlEmprestimo);
                 PreparedStatement stmtLivro = conn.prepareStatement(sqlLivro)) {

                // Converter java.util.Date para java.sql.Date
                java.sql.Date sqlDataEmprestimo = new java.sql.Date(emprestimo.getDataEmprestimo().getTime());
                java.sql.Date sqlDataDevolucao = new java.sql.Date(emprestimo.getDataDevolucao().getTime());

                // Configurar parâmetros do empréstimo
                stmtEmprestimo.setInt(1, emprestimo.getLivroId());
                stmtEmprestimo.setInt(2, emprestimo.getUsuarioId());
                stmtEmprestimo.setDate(3, sqlDataEmprestimo);
                stmtEmprestimo.setDate(4, sqlDataDevolucao);
                stmtEmprestimo.setBoolean(5, emprestimo.isDisponivel());
                stmtEmprestimo.executeUpdate();

                // Atualizar disponibilidade do livro
                stmtLivro.setInt(1, emprestimo.getLivroId());
                int rowsAffected = stmtLivro.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Livro atualizado para indisponível com sucesso!");
                } else {
                    System.out.println("Nenhum livro foi encontrado para atualizar!");
                }

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao registrar empréstimo", e);
            }
        }

    // Método para registrar devolução de empréstimo
    public boolean registrarDevolucao(Emprestimo emprestimo) {
        String sqlDevolucao = "UPDATE emprestimo SET disponivel = 1, dataDevolucao = ? WHERE livroId = ? AND usuarioId = ? AND disponivel = 0";
        String sqlLivro = "UPDATE livro SET disponivel = true WHERE id = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmtDevolucao = conn.prepareStatement(sqlDevolucao);
             PreparedStatement stmtLivro = conn.prepareStatement(sqlLivro)) {

            java.sql.Date sqlDataDevolucao = new java.sql.Date(emprestimo.getDataDevolucao().getTime());

            // Atualizar empréstimo
            stmtDevolucao.setDate(1, sqlDataDevolucao);
            stmtDevolucao.setInt(2, emprestimo.getLivroId());
            stmtDevolucao.setInt(3, emprestimo.getUsuarioId());

            int rowsAffectedEmprestimo = stmtDevolucao.executeUpdate();

            // Atualizar livro para disponível
            stmtLivro.setInt(1, emprestimo.getLivroId());
            int rowsAffectedLivro = stmtLivro.executeUpdate();

            // Verificar se as atualizações foram realizadas
            return rowsAffectedEmprestimo > 0 && rowsAffectedLivro > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao registrar devolução", e);
        }
    }
}
