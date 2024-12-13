package Controller;

import Controller.Helper.TelaEmprestimoHelper;
import dao.EmprestimoDAO;
import java.text.ParseException;
import java.util.Date;
import model.Emprestimo;
import view.Menu;
import view.TelaEmprestimo;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaEmprestimoController {   

    private final TelaEmprestimo view;
    private final TelaEmprestimoHelper helper;
    private final EmprestimoDAO emprestimoDAO;

    public TelaEmprestimoController(TelaEmprestimo view) {
        this.view = view;
        this.helper = new TelaEmprestimoHelper(view); // ajudante
        this.emprestimoDAO = new EmprestimoDAO();  // Instancia o DAO
    }
    
    public void AtualizarData(int idUsuario, Date novaDataDevolucao) {
        try {
            helper.atualizarDataDevolucao(idUsuario, novaDataDevolucao);
        } catch (ParseException e) {
            Logger.getLogger(TelaEmprestimoController.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception e) {
            Logger.getLogger(TelaEmprestimoController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
     
    //Metodo que cadastra emprestimo - executa quando clico no botao entrar
        public void realizarEmprestimo() throws ParseException {
    // Pegar dados do empréstimo
    Emprestimo emprestimo = helper.obterModelo();

    // Verificar se o livro está disponível
    boolean livroDisponivel = emprestimoDAO.verificarDisponibilidadeLivro(emprestimo.getLivroId());

    if (!livroDisponivel) {
        view.exibeMensagem("Este livro está indisponível para empréstimo!");
        return; // Interrompe o processo
    }

    // Marcar como indisponível
    emprestimo.setDisponivel(false);

    // Cadastrar o empréstimo no banco
    try {
        emprestimoDAO.inserirEmprestimo(emprestimo);
        view.exibeMensagem("Empréstimo realizado com sucesso!");
    } catch (Exception e) {
        view.exibeMensagem("Erro ao realizar empréstimo: " + e.getMessage());
    }
}
    


    public void limparCampos() {
        helper.limparTela();
    }
    
    
    //calcular e exibir automaticamente a data de devolução assim que a data de empréstimo for preenchida.
    public void atualizarDataDevolucao()  {
        helper.calcularDataDevolucaoAutomatica();
    }

     public void navegarParaMenu() throws ParseException{
        Menu menu= new Menu();
        menu.setVisible(true);
        
    }

}
