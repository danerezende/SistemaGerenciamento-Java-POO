package Controller.Helper;

import dao.CategoriaDAO;
import dao.LivroDAO;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Categoria;
import model.Livro;
import view.TelaListagemLivros;

public class TelaListagemLivrosHelper {
    
    private final TelaListagemLivros view;
    
    public TelaListagemLivrosHelper (TelaListagemLivros view) {
        this.view = view;
    }
//metodo para preencher tabela
    public void preencherTabela(List<Livro> livros) {
    DefaultTableModel model = (DefaultTableModel)   view.getjTable1().getModel();
    model.setRowCount(0); // Limpar a tabela antes de preencher com os novos dados
  
      //percorrer a lista preenchenddo a table model 
        for (Livro livro : livros) {
            model.addRow(new Object[]{
                livro.getId(),
                livro.getTitulo(),
                livro.getAutor(),
                livro.getCategoria().getNome(),
                livro.getIsbn(),
                livro.getAnoPublicacao(),
                livro.isDisponivel() ? "Disponível" : "Indisponível"
            });
        }
    
    }
    
    //-----------------------------------------------------------------------------
    public Livro obterLivroSelecionado() {
    int linhaSelecionada = view.getjTable1().getSelectedRow(); // Obtém a linha selecionada
    if (linhaSelecionada != -1) {
        // Obtém os dados da linha selecionada
        int id = (int) view.getjTable1().getValueAt(linhaSelecionada, 0);
        String titulo = (String) view.getjTable1().getValueAt(linhaSelecionada, 1);
        String autor = (String) view.getjTable1().getValueAt(linhaSelecionada, 2);
        String categoriaNome = (String) view.getjTable1().getValueAt(linhaSelecionada, 3);
        String isbn = (String) view.getjTable1().getValueAt(linhaSelecionada, 4);
        int ano = (int) view.getjTable1().getValueAt(linhaSelecionada, 5);
        boolean disponivel = "Sim".equals(view.getjTable1().getValueAt(linhaSelecionada, 6));

        Categoria categoria = new CategoriaDAO().buscarPorNome(categoriaNome);

        // Retorna o livro selecionado
        return new Livro(id, titulo, autor, categoria, isbn, ano, disponivel);
    }
    return null; // Nenhuma linha selecionada
}

    //....................................................................................................................................
public Livro obterLivroEditado() {
    int linhaSelecionada = view.getjTable1().getSelectedRow(); // Obtém a linha selecionada
    if (linhaSelecionada != -1) {
        // Obtém os dados da linha selecionada
        int id = (int) view.getjTable1().getValueAt(linhaSelecionada, 0);
        String titulo = (String) view.getjTable1().getValueAt(linhaSelecionada, 1);
        String autor = (String) view.getjTable1().getValueAt(linhaSelecionada, 2);
        String categoriaNome = (String) view.getjTable1().getValueAt(linhaSelecionada, 3);
        String isbn = (String) view.getjTable1().getValueAt(linhaSelecionada, 4);
        int ano = (int) view.getjTable1().getValueAt(linhaSelecionada, 5);
        // Verifique se "Sim" ou "Não" para setar o valor de disponivel corretamente
        boolean disponivel = "Disponível".equals(view.getjTable1().getValueAt(linhaSelecionada, 6));

        Categoria categoria = new CategoriaDAO().buscarPorNome(categoriaNome);

        // Retorna o livro selecionado
        return new Livro(id, titulo, autor, categoria, isbn, ano, disponivel);
    }
    return null; // Nenhuma linha selecionada
}
}
