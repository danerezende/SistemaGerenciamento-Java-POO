package Controller.Helper;

import model.Bibliotecario;
import View.Login;
import java.text.ParseException;
import javax.swing.text.View;

public class LoginHelper {
 
    private final Login view;
    
    public LoginHelper(Login view) {
        this.view = view;
    }
    
    
    public Bibliotecario obterModelo() throws ParseException{
        String nome = view.getTextLogin().getText();   
        String senha = view.getTextSenha().getText();     
        Bibliotecario modelo = new Bibliotecario(nome, senha);
        return modelo;

    }
    
    public void setarModelo(Bibliotecario modelo){
        String nome = modelo.getNome();
        String senha = modelo.getSenha();
        
        view.getTextLogin().setText(nome);
        view.getTextSenha().setText(senha);
    }
    
   
    public void limparTela(){
        view.getTextLogin().setText("");
        view.getTextSenha().setText("");
    }
}