package Controller;

import Controller.Helper.TelaCadastroHelper;
import dao.BibliotecarioDAO;
import dao.LeitorDAO;
import dao.UsuarioDAO;  // Importa o DAO para poder salvar o usuário no banco
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Bibliotecario;
import model.Usuario;
import view.Menu;
import view.TelaCadastroCliente;
import model.Leitor;
import model.Multa;

public class TelaCadastroController {
    
    public final TelaCadastroCliente view;
    private TelaCadastroHelper helper;
    private UsuarioDAO usuarioDAO; // Referência para o DAO

    // Construtor
    public TelaCadastroController(TelaCadastroCliente view) {
        this.view = view;
        this.helper = new TelaCadastroHelper(view); // Ajudante
        this.usuarioDAO = new UsuarioDAO();  // Instancia o DAO
    }
    
    // Método que cadastra o usuário - executa quando clico no botao entrar
    public void cadastrarUser() throws ParseException {
        // Pega o modelo de usuário da view
        Usuario usuario = helper.obterModelo();
        
        // Cadastra o usuário no banco---------------------------------------------------------
        try {
            usuarioDAO.cadastrarUsuario(usuario);
        } catch (Exception e) {
        }
    }
    
    // Método chamado quando o usuário for cadastrado com sucesso - MENSAGEM 
    public void usuarioCadastrado() {
        System.out.println("Usuario Cadastrado com sucesso!");
        this.view.exibeMensagem("Usuário Cadastrado");
    }

    // Método para limpar os campos da tela
    public void limparCampos() {
        helper.limparTela();
    }
    
    
     public void navegarParaMenu() throws ParseException{
        Menu menu= new Menu();
        menu.setVisible(true);
        
    }
     
     
        public void cadastrarBibliotecario(String nome, String setor, String turno, String senha) {
    try {
        // Se o id foi encontrado, criamos o bibliotecário e chamamos o DAO
        Bibliotecario bibliotecario = new Bibliotecario(nome, setor, turno, senha);
        BibliotecarioDAO bibliotecarioDAO = new BibliotecarioDAO();
        bibliotecarioDAO.inserirBibliotecario(bibliotecario);
        System.out.println("Bibliotecário cadastrado com sucesso!");
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Erro ao cadastrar bibliotecário.");
    }
}
        public void cadastrarLeitor(String nome, Date dataDevolucao, List<Multa> multasPendentes) {
        try {
               
        if (multasPendentes == null) {
            multasPendentes = new ArrayList<>();
        }
        // Se o id foi encontrado, criamos o bibliotecário e chamamos o DAO
        Leitor leitor = new Leitor(nome,dataDevolucao,multasPendentes);
        LeitorDAO leitorDAO = new LeitorDAO();
        leitorDAO.inserirLeitor(leitor);
        System.out.println("Leitor cadastrado com sucesso!");
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Erro ao cadastrar Leitor.");
    }
}
}
