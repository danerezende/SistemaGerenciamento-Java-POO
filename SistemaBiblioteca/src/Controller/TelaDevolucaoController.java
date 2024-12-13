package Controller;

import Controller.Helper.TelaDevolucaoHelper;
import dao.EmprestimoDAO;
import dao.MultaDAO;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.JOptionPane;
import model.Emprestimo;
import model.Multa;
import model.Usuario;
import view.Menu;
import view.TelaDevolucao;

public class TelaDevolucaoController {
    
    public final TelaDevolucao view;
    private TelaDevolucaoHelper helper;
    private EmprestimoDAO usuarioDAO; // Referência para o DAO

    // Construtor
    public TelaDevolucaoController(TelaDevolucao view) {
        this.view = view;
        this.helper = new TelaDevolucaoHelper(view); // Ajudante
        this.usuarioDAO = new EmprestimoDAO();  // Instancia o DAO
    }
   
//obtem modelo helper
public void registrarDevolucao() throws ParseException {
    // Obter dados do empréstimo a partir da tela
    Emprestimo emprestimo = helper.obterModeloEmprestimo();

    // Atualizar empréstimo no banco de dados
    EmprestimoDAO emprestimoDAO = new EmprestimoDAO();
    boolean devolucaoConcluida = emprestimoDAO.registrarDevolucao(emprestimo);

    if (devolucaoConcluida) {
        // Atualizar multa
        atualizarMulta();

        // Enviar dados da multa para o banco
        enviarMultaBanco();

        // Exibir mensagem de sucesso
        JOptionPane.showMessageDialog(view, "Devolução realizada com sucesso!");
    } else {
        JOptionPane.showMessageDialog(view, "Erro ao gerar multa.");
    }
}


  // Método chamado quando o usuário for cadastrado com sucesso - MENSAGEM
    public void devolucaoCadastrada() {
        System.out.println("Devolucao Realizada");
        this.view.exibeMensagem("Devolução Realizada!");
    }
//MULTA
//chama metodo calcular multa do helper..................................................................................................
            public void atualizarMulta() {
                try {
                    // Obter o modelo de empréstimo a partir da tela
                    Emprestimo emprestimo = helper.obterModeloEmprestimo();

                    // Calcular a multa com base nas datas
                    double multa = helper.calcularMulta(emprestimo.getDataEmprestimo(), emprestimo.getDataDevolucao());

                    // Atualizar o campo de multa na tela
                    view.getTextMulta().setText(String.format("%.2f", multa));
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(view, "Erro ao atualizar multa: " + e.getMessage());
                }
            }

            public void enviarMultaBanco() {
                try {
                    // Obter o valor da multa exibido na tela e substituir vírgula por ponto
                    String valorMultaTexto = view.getTextMulta().getText().trim().replace(",", ".");
                    double valorMulta = Double.parseDouble(valorMultaTexto);

                    // Criar o modelo de multa
                    Multa multa = helper.obterModeloMulta(valorMulta);

                    // Registrar a multa no banco de dados
                    MultaDAO multaDAO = new MultaDAO();
                    multaDAO.registrarMulta(multa);

                    } catch (Exception e) {
                        // Aqui você captura e exibe o erro completo
                        e.printStackTrace(); // Mostra o erro no console (para depuração)
                        JOptionPane.showMessageDialog(view, "Erro ao registrar multa: " + e.getMessage());
                    }
                
                
            }
//===========================
     public void navegarParaMenu() throws ParseException{
        Menu menu= new Menu();
        menu.setVisible(true);
        
    }
     
     
     
     
     
     
     
     
     
     
     
     
     
}