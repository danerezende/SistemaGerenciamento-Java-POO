package Controller;

import Controller.Helper.TelaListagemLivrosHelper;
import dao.LivroDAO;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Categoria;
import model.Livro;
import view.Menu;
import view.TelaListagemLivros;


public class TelaListagemLivrosController {   
    

    public final TelaListagemLivros view;
    private final TelaListagemLivrosHelper helper;
    private LivroDAO livroDAO; // Referência para o DAO

    // Construtor
    public TelaListagemLivrosController(TelaListagemLivros view) {
        this.view = view;
        this.helper = new TelaListagemLivrosHelper(view); // Ajudante
        this.livroDAO = new LivroDAO();  // Instancia o DAO
    }

    
    // Método para carregar livros na JTable
    public void carregarTabela(JTable tabelaLivros) {
     //buscar dados banco
        LivroDAO livroDAO = new LivroDAO();
        List<Livro> livros = livroDAO.listar();
    //exibir na view
        helper.preencherTabela(livros);       

    }
    

             public void navegarParaMenu() throws ParseException{
        Menu menu= new Menu();
        menu.setVisible(true);
        
}
        //----------------------------------------------------------------------
             
        public  void excluirLivro() {
    // Obtém o livro selecionado na tabela por meio do helper
    Livro livroSelecionado = helper.obterLivroSelecionado();

    if (livroSelecionado != null) {
        // Confirma a exclusão
        int confirmacao = JOptionPane.showConfirmDialog(null, 
            "Deseja realmente excluir o livro: " + livroSelecionado.getTitulo() + "?",
            "Confirmação de Exclusão", 
            JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            // Remove o livro do banco de dados
            LivroDAO livroDAO = new LivroDAO();
            livroDAO.excluir(livroSelecionado.getId());

            // Atualiza a tabela
            atualizarTabela();
            JOptionPane.showMessageDialog(null, "Livro excluído com sucesso!");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, selecione um livro para excluir.");
    }
}
        
public void atualizarTabela() {
    List<Livro> livros = new LivroDAO().listar(); // Busca os dados atualizados
    helper.preencherTabela(livros); // Atualiza a tabela na view
}

   //..........................................................................................
public void atualizarLivro() {
    // Obter o livro editado diretamente da JTable (helper)
    Livro livroEditado = helper.obterLivroEditado();

    if (livroEditado != null) {
        LivroDAO livroDAO = new LivroDAO();

        // Atualizar no banco
        boolean sucesso = livroDAO.atualizar(livroEditado);

        if (sucesso) {
            // Atualizar tabela na view
            carregarTabela(view.getjTable1());
            JOptionPane.showMessageDialog(view, "Livro atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(view, "Erro ao atualizar o livro.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(view, "Selecione um livro para atualizar.", "Aviso", JOptionPane.WARNING_MESSAGE);
    }
}

    
}
