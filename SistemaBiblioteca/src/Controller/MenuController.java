package Controller;

import View.Login;
import java.text.ParseException;
import view.Menu;
import view.TelaCadastroCliente;
import view.TelaDevolucao;
import view.TelaEmprestimo;
import view.TelaGestaoMulta;
import view.TelaListagemLivros;


public class MenuController {

    private final Menu view;
    

    public MenuController(Menu view) {
        this.view = view;
    }
     
    
         public void navegarParaCadastro() throws ParseException{
         TelaCadastroCliente telacadastrocliente = new TelaCadastroCliente();
         telacadastrocliente.setVisible(true);
        
    }
    
        public void navegarParaEmprestimo() throws ParseException{
        TelaEmprestimo telaemprestimo = new TelaEmprestimo();
        telaemprestimo.setVisible(true);
        
    }
        
        public void navegarParaDevolucao() throws ParseException{
        TelaDevolucao teladevolucao = new TelaDevolucao();
        teladevolucao.setVisible(true);

        
    }
        
        public void navegarParaMultas() throws ParseException{
        TelaGestaoMulta telagestaomulta = new TelaGestaoMulta();
        telagestaomulta.setVisible(true);
      
        
    }
        
         public void navegarParaListagem() throws ParseException{
        TelaListagemLivros telalistagemlivros= new TelaListagemLivros();
        telalistagemlivros.setVisible(true);
        
    }         
         
     public void navegarParaLogin() throws ParseException{
        Login login= new Login();
        login.setVisible(true);
        
}
     
}
