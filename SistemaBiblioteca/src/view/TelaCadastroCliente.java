package view;

import Controller.TelaCadastroController;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class TelaCadastroCliente extends javax.swing.JFrame {
    
    private final TelaCadastroController controller;

 
    public TelaCadastroCliente() {
        initComponents();
        controller = new TelaCadastroController(this); //controller
        setLocationRelativeTo(null); // Centraliza a janela na tela
        this.setTitle("Sistema Biblioteca - Cadastro Usuário"); // Define o título

        

    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextTel = new javax.swing.JTextField();
        TextEmail = new javax.swing.JTextField();
        ButVoltar = new javax.swing.JButton();
        TextNome = new javax.swing.JTextField();
        TextData = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        butCadastrar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        LabelTelefone = new javax.swing.JLabel();
        LabelTipo = new javax.swing.JLabel();
        LabelData = new javax.swing.JLabel();
        LabelEmail = new javax.swing.JLabel();
        LabelNome = new javax.swing.JLabel();
        labelCadastroCliente = new javax.swing.JLabel();
        painelCadastro = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(TextTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 390, 180, -1));
        getContentPane().add(TextEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 340, 180, -1));

        ButVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/icons8-sair-24.png"))); // NOI18N
        ButVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(ButVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 610, 20, 20));
        getContentPane().add(TextNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 180, -1));
        getContentPane().add(TextData, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 490, 180, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/log_menor.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, -1, 30));

        butCadastrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butCadastrar.setText("Cadastrar");
        butCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCadastrarActionPerformed(evt);
            }
        });
        getContentPane().add(butCadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, 130, 30));

        jComboBox1.setMaximumRowCount(2);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Leitor", "Bibliotecário" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 440, 180, -1));

        LabelTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelTelefone.setText("Telefone");
        getContentPane().add(LabelTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 390, -1, -1));

        LabelTipo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelTipo.setText("Tipo");
        getContentPane().add(LabelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 440, -1, -1));

        LabelData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelData.setText("Data Cadastro");
        getContentPane().add(LabelData, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 490, -1, -1));

        LabelEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelEmail.setText("Email");
        getContentPane().add(LabelEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, -1, -1));

        LabelNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelNome.setText("Nome");
        getContentPane().add(LabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, -1));

        labelCadastroCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labelCadastroCliente.setText("Cadastro Usuário");
        getContentPane().add(labelCadastroCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, -1, -1));

        painelCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/fundo1.png"))); // NOI18N
        painelCadastro.setText("jLabel2");
        getContentPane().add(painelCadastro, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 430, 510));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/book1.jpg"))); // NOI18N
        background.setText("jLabel1");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCadastrarActionPerformed
        // executa quando clico no botao entrar
         if (TextNome.getText().isEmpty() || 
        TextEmail.getText().isEmpty() || 
        TextTel.getText().isEmpty() || 
        TextData.getText().isEmpty() || 
        jComboBox1.getSelectedItem() == null) {
        
        JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }
        
        try{
            this.controller.cadastrarUser();
       } catch (ParseException e){
       }
        this.controller.usuarioCadastrado();
        
        String nome = TextNome.getText();
        String email = TextEmail.getText();
        String tipo = jComboBox1.getSelectedItem().toString();
 
        System.out.println(TextNome.getText());//nome
        System.out.println(TextEmail.getText());//email
        System.out.println(TextTel.getText());//telefone
        System.out.println(jComboBox1.getSelectedItem());//tipo jComboBox1.getSelectedItem()
        System.out.println(TextData.getText());//data cadastro
        
        if (tipo.equals("Bibliotecário")) {
        // Pop-up para informações adicionais
        JTextField setorField = new JTextField();
        JTextField turnoField = new JTextField();
        JTextField senhaField = new JTextField();

        Object[] message = {
            "Setor:", setorField,
            "Turno:", turnoField,
            "Senha:", senhaField,
            };

        int option = JOptionPane.showConfirmDialog(null, message, "Informações Adicionais - Bibliotecário", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String setor = setorField.getText();
            String turno = turnoField.getText();
            String senha = senhaField.getText();
            

            // Passa os dados para o Controller
            this.controller.cadastrarBibliotecario(nome, setor,turno, senha);
        }
        } else {
            this.controller.cadastrarLeitor(nome,null,null);
        }
    }//GEN-LAST:event_butCadastrarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void ButVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButVoltarActionPerformed
        try {
            this.controller.navegarParaMenu();
        } catch (ParseException ex) {
            Logger.getLogger(TelaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                // Fechar a tela
        dispose();
    }//GEN-LAST:event_ButVoltarActionPerformed

   
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButVoltar;
    private javax.swing.JLabel LabelData;
    private javax.swing.JLabel LabelEmail;
    private javax.swing.JLabel LabelNome;
    private javax.swing.JLabel LabelTelefone;
    private javax.swing.JLabel LabelTipo;
    private javax.swing.JTextField TextData;
    private javax.swing.JTextField TextEmail;
    private javax.swing.JTextField TextNome;
    private javax.swing.JTextField TextTel;
    private javax.swing.JLabel background;
    private javax.swing.JButton butCadastrar;
    public javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel labelCadastroCliente;
    private javax.swing.JLabel painelCadastro;
    // End of variables declaration//GEN-END:variables

    
    public void exibeMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    //get and set
    
    public JTextField getTextData() {
        return TextData;
    }

    public void setTextData(JTextField TextData) {
        this.TextData = TextData;
    }

    public JTextField getTextEmail() {
        return TextEmail;
    }

    public void setTextEmail(JTextField TextEmail) {
        this.TextEmail = TextEmail;
    }

    public JTextField getTextNome() {
        return TextNome;
    }

    public void setTextNome(JTextField TextNome) {
        this.TextNome = TextNome;
    }

    public JTextField getTextTel() {
        return TextTel;
    }

    public void setTextTel(JTextField TextTel) {
        this.TextTel = TextTel;
    }


    
    
}
