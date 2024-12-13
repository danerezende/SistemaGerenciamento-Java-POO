package Controller;

import Controller.Helper.LoginHelper;
import View.Login;
import dao.LoginDAO;
import java.text.ParseException;
import model.Bibliotecario;
import view.Menu;

public class LoginController {


    private final Login view;
    private final LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }

    public void autenticar() throws ParseException {
        // Obtém os dados da view
        Bibliotecario modelo = helper.obterModelo();

        // Chama o DAO para validar o login
        LoginDAO dao = new LoginDAO();
        boolean loginValido = dao.validarLogin(modelo.getNome(), modelo.getSenha());

        // Verifica se o login é válido e age de acordo
        if (loginValido) {
            view.mostrarMensagem("Login realizado com sucesso!");
            // Redirecionar para outra tela 
            navegarParaMenu();
        } else {
            view.mostrarMensagem("Nome ou senha inválidos!");
        }
    }   
    
    public void navegarParaMenu() {
        // Criar uma instância da tela de menu
        Menu menu = new Menu();

        // Torna a tela de menu visível
        menu.setVisible(true);

        // Opcional: fecha a tela de login (se necessário)
        view.dispose();
            
    }

}