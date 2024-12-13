
package Controller.Helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Usuario;
import view.TelaCadastroCliente;


public class TelaCadastroHelper {
    
    
private final TelaCadastroCliente view;
    
    public TelaCadastroHelper (TelaCadastroCliente view) {
        this.view = view;
    }
    
    
    public Usuario obterModelo() throws ParseException{
        String nome = view.getTextNome().getText();   
        String email = view.getTextEmail().getText();   
        String telefone = view.getTextTel().getText();   
        String tipo = view.jComboBox1.getSelectedItem().toString();
        String dataCadastro = view.getTextData().getText();   
        
        
        Usuario modelo = new Usuario(0, nome, email, telefone, tipo, dataCadastro);
        return modelo;

    }
    
    public void setarModelo(Usuario modelo){
        String nome = modelo.getNome(); 
        String email = modelo.getEmail();  
        String telefone = modelo.getTelefone();  
        String tipo = modelo.getTipo();
        Date dataCadastro = modelo.getDataCadastro(); 
        
        view.getTextNome().setText(nome);
        view.getTextEmail().setText(email);
        view.getTextTel().setText(telefone);
        view.jComboBox1.setSelectedItem(tipo);
        SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
        view.getTextData().setText(sdf.format(dataCadastro));
    }
    
   
    public void limparTela(){
         
        view.getTextNome().setText("");
        view.getTextEmail().setText("");
        view.getTextTel().setText("");
        view.getTextData().setText("");
    }
}