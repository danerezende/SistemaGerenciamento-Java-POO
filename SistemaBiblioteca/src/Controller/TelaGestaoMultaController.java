package Controller;

import Controller.Helper.TelaGestaoMultaHelper;
import dao.MultaDAO;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Multa;
import view.Menu;
import view.TelaGestaoMulta;


public class TelaGestaoMultaController {   
    

    public final TelaGestaoMulta view;
    private final TelaGestaoMultaHelper helper;
    private MultaDAO multaDAO; // Referência para o DAO

    // Construtor
    public TelaGestaoMultaController(TelaGestaoMulta view) {
        this.view = view;
        this.helper = new TelaGestaoMultaHelper(view); // Ajudante
        this.multaDAO = new MultaDAO();  // Instancia o DAO
    }

    
    // Método para carregar livros na JTable
    public void carregarTabela(JTable tabelaLivros) {
     //buscar dados banco
        MultaDAO multaDAO = new MultaDAO();
        List<Multa> multas = multaDAO.listar();
    //exibir na view
        helper.preencherTabela(multas);       

    }
    

             public void navegarParaMenu() throws ParseException{
        Menu menu= new Menu();
        menu.setVisible(true);
        
}
        //----------------------------------------------------------------------
             
        public  void excluirMulta() {
    // Obtém o livro selecionado na tabela por meio do helper
    Multa multaSelecionada = helper.obterMultaSelecionada();

    if (multaSelecionada != null) {
        // Confirma a exclusão
        int confirmacao = JOptionPane.showConfirmDialog(null, 
            "Deseja validar pagamento do valor R$ " + multaSelecionada.getValor() + "?",
            "Confirmação de Pagamento", 
            JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            // Remove o livro do banco de dados
            MultaDAO multaDAO = new MultaDAO();
            multaDAO.excluir(multaSelecionada.getId());

            // Atualiza a tabela
            atualizarTabela();
            JOptionPane.showMessageDialog(null, "Pagamento Efetuado!");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, selecione uma multa para pagamento.");
    }
}
        
public void atualizarTabela() {
    List<Multa> multas = new MultaDAO().listar(); // Busca os dados atualizados
    helper.preencherTabela(multas); // Atualiza a tabela na view
}
    
}
