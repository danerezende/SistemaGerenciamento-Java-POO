package Controller;

import dao.CategoriaDAO;
import model.Categoria;
import java.time.LocalDate;


public class CategoriaController {
    

    public static void main(String[] args) {
        CategoriaDAO categoriaDAO = new CategoriaDAO();

        // Categorias
        String[][] categorias = {
            {"Ficção Científica", "Categoria para livros de ficção científica"},
            {"Fantasia", "Categoria para livros de fantasia"},
            {"Romance", "Categoria para livros de romance"},
            {"Terror", "Categoria para livros de terror"},
            {"Aventura", "Categoria para livros de aventura"},
            {"História", "Categoria para livros históricos"},
            {"Biografia", "Categoria para livros biográficos"},
            {"Autoajuda", "Categoria para livros de autoajuda"},
            {"Suspense", "Categoria para livros de suspense"},
            {"Clássicos", "Categoria para livros clássicos"},
            {"Filosofia", "Categoria para livros de filosofia"},
            {"Psicologia", "Categoria para livros de psicologia"},
            {"Ciências Exatas", "Categoria para livros de ciências exatas"},
            {"Negócios", "Categoria para livros sobre negócios"}
        };

        // Inserir categorias no banco de dados
        for (String[] categoriaData : categorias) {
            String nomeCategoria = categoriaData[0];
            String descricaoCategoria = categoriaData[1];

            Categoria categoria = new Categoria(
                nomeCategoria,               // Nome
                descricaoCategoria,          // Descrição
                LocalDate.now()              // Data de cadastro
            );

            boolean sucesso = categoriaDAO.incluirCategoria(categoria);
            if (sucesso) {
                System.out.println("Categoria \"" + nomeCategoria + "\" incluída com sucesso!");
            } else {
                System.out.println("Erro ao incluir a categoria \"" + nomeCategoria + "\".");
            }
        }
    }
}