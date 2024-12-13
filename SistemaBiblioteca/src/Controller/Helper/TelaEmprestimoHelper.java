package Controller.Helper;

import dao.LeitorDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import model.Emprestimo;
import view.TelaEmprestimo;

public class TelaEmprestimoHelper {   

    private final TelaEmprestimo view;
    private LeitorDAO leitorDAO;

    public TelaEmprestimoHelper(TelaEmprestimo view) {
        this.view = view;
        leitorDAO = new LeitorDAO();
    }
    
    public void atualizarDataDevolucao(int idUsuario, Date novaDataDevolucao) throws Exception {
        leitorDAO.atualizarDataDevolucaoPorNome(idUsuario, novaDataDevolucao);
    }

public Emprestimo obterModelo() throws ParseException {
    int livroId = Integer.parseInt(view.getTextLivroId().getText());
    int usuarioId = Integer.parseInt(view.getTextUsuarioId().getText());

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Obter as datas no formato correto
    Date dataEmprestimo = sdf.parse(view.getTextDataEmprestimo().getText());
    Date dataDevolucao = sdf.parse(view.getTextDataDevolucao().getText());

    // Retornar o objeto Emprestimo com datas como java.util.Date
    return new Emprestimo(0, livroId, usuarioId, dataEmprestimo, dataDevolucao, true);
}


public void setarModelo(Emprestimo modelo) {
    int livroId = modelo.getLivroId(); 
    int usuarioId = modelo.getUsuarioId();  
    Date dataEmprestimo = modelo.getDataEmprestimo(); 
    Date dataDevolucao = modelo.getDataDevolucao(); 

    // Formatar as datas para o formato "dd/MM/yyyy"
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    view.getTextLivroId().setText(String.valueOf(livroId)); 
    view.getTextUsuarioId().setText(String.valueOf(usuarioId)); 
    view.getTextDataEmprestimo().setText(sdf.format(dataEmprestimo)); 
    view.getTextDataDevolucao().setText(sdf.format(dataDevolucao)); 
}


    public void limparTela() {
        view.getTextLivroId().setText("");
        view.getTextUsuarioId().setText("");
        view.getTextDataEmprestimo().setText("");
        view.getTextDataDevolucao().setText("");
    }

    public void calcularDataDevolucaoAutomatica() {
        try {
            String dataEmprestimoStr = view.getTextDataEmprestimo().getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date dataEmprestimo = sdf.parse(dataEmprestimoStr);

            // Adicionar 7 dias à data de empréstimo
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dataEmprestimo);
            calendar.add(Calendar.DAY_OF_MONTH, 7);  // Altere o número de dias conforme necessário
            Date dataDevolucao = calendar.getTime();

            // Definir a devolução no campo da view
            view.getTextDataDevolucao().setText(sdf.format(dataDevolucao));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
