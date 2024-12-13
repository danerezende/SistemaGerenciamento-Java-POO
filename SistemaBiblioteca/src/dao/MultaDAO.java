package dao;

import dao.Conexao;
import model.Multa;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class MultaDAO {

    // Método para registrar uma nova multa
            public void registrarMulta(Multa multa) {
                // Verifica se o valor da multa é maior que 0
                if (multa.getValor() <= 0) {
                    System.out.println("Multa não registrada: valor inválido (0.00).");
                    return; // Não registra no banco se o valor for 0.00
                }

                String sql = "INSERT INTO multa (usuarioId, valor, dataMulta, status) VALUES (?, ?, ?, ?)";
                try (Connection conexao = new Conexao().getConnection();
                     PreparedStatement stmt = conexao.prepareStatement(sql)) {

                    // Imprime detalhes de depuração
                    System.out.println("Registrando multa para o usuário ID: " + multa.getUsuarioId());

                    stmt.setInt(1, multa.getUsuarioId());
                    stmt.setDouble(2, multa.getValor());
                    stmt.setDate(3, new java.sql.Date(multa.getDataMulta().getTime()));
                    stmt.setString(4, "pendente"); // Supondo que 'pendente' seja o valor padrão

                    stmt.executeUpdate(); // Executa a inserção
                    System.out.println("Multa registrada com sucesso!");
                } catch (SQLException e) {
                    throw new RuntimeException("Erro ao registrar devolução", e);
                }
            }


    
 // Método para listar todas as multas no banco de dados
    public List<Multa> listar() {
        List<Multa> multas = new ArrayList<>();
        String sql = "SELECT l.id, l.usuarioId, l.valor, l.dataMulta, l.status FROM Multa l";  // Query para obter as multas

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            // Definir o formato da data para conversão de String para Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            while (rs.next()) {
                // Criando o objeto Multa e preenchendo com os dados do ResultSet
                int id = rs.getInt("id");
                int usuarioId = rs.getInt("usuarioId");
                double valor = rs.getDouble("valor");
                String dataMultaStr = rs.getString("dataMulta");
                String status = rs.getString("status");

                // Converter a data de String para Date
                java.util.Date dataMulta = sdf.parse(dataMultaStr);

                // Criando o objeto Multa com os dados recuperados
                Multa multa = new Multa(id, usuarioId, valor, dataMulta, status);
                multas.add(multa);  // Adiciona a multa à lista
            }
        } catch (SQLException | java.text.ParseException e) {
            e.printStackTrace();  // Tratamento de exceção
        }

        return multas;  // Retorna a lista de multas
    }

    // Método para excluir uma multa do banco de dados
    public void excluir(int id) {
        String sql = "DELETE FROM Multa WHERE id = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
