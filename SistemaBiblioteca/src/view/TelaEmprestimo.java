package view;

import Controller.TelaEmprestimoController;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Controller.Helper.TelaEmprestimoHelper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TelaEmprestimo extends javax.swing.JFrame {

    private final TelaEmprestimoController controller;  

 
    public TelaEmprestimo() {
        initComponents();
        controller = new TelaEmprestimoController(this); //controller
        this.setTitle("Sistema Biblioteca - Empréstimo"); // Define o título
        setLocationRelativeTo(null); // Centraliza a janela na tela

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        butConfirmar = new javax.swing.JButton();
        Logo = new javax.swing.JLabel();
        TextUsuarioId = new javax.swing.JTextField();
        TextDataEmprestimo = new javax.swing.JTextField();
        TextDataDevolucao = new javax.swing.JTextField();
        ButVoltar = new javax.swing.JButton();
        TextLivroId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        butConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butConfirmar.setText("Confirmar");
        butConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(butConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 560, 130, 30));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/log_menor.png"))); // NOI18N
        getContentPane().add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, -1, 30));
        getContentPane().add(TextUsuarioId, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 180, -1));

        TextDataEmprestimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextDataEmprestimoActionPerformed(evt);
            }
        });
        getContentPane().add(TextDataEmprestimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, 180, -1));
        getContentPane().add(TextDataDevolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 470, 180, -1));

        ButVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/icons8-sair-24.png"))); // NOI18N
        ButVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(ButVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 620, 20, 20));
        getContentPane().add(TextLivroId, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 290, 180, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Data Empréstimo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 110, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Data Devolução");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 470, 110, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Id Usuário");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, 90, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Empréstimo Livro");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 210, 160, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Código Livro");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 90, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/fundo1.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 430, 520));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/book1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butConfirmarActionPerformed
        if (TextLivroId.getText().isEmpty() || 
            TextUsuarioId.getText().isEmpty() || 
            TextDataEmprestimo.getText().isEmpty() || 
            TextDataDevolucao.getText().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            this.controller.realizarEmprestimo();
        } catch (ParseException ex) {
            Logger.getLogger(TelaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        try {
            // Obtendo o ID do usuário e a nova data de devolução da View
            int idUsuario = Integer.parseInt(TextUsuarioId.getText()); // Captura do ID
            String novaDataDevolucaoStr = TextDataDevolucao.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Formato de data esperado
            java.util.Date sqlDataDevolucao = sdf.parse(novaDataDevolucaoStr);
            java.sql.Date novaDataDevolucao = new java.sql.Date(sqlDataDevolucao.getTime());

            // Chamando o método do controller para atualizar a data com o ID e a nova data
            controller.AtualizarData(idUsuario, novaDataDevolucao);
        } catch (NumberFormatException ex) {
            Logger.getLogger(TelaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {  
            Logger.getLogger(TelaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.controller.limparCampos();

        // Debug
        System.out.println(TextLivroId.getText()); // Código do livro
        System.out.println(TextUsuarioId.getText()); // Código do usuário
        System.out.println(TextDataEmprestimo.getText()); // Data de empréstimo
        System.out.println(TextDataDevolucao.getText()); // Data de devolução


    }//GEN-LAST:event_butConfirmarActionPerformed

    private void TextDataEmprestimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextDataEmprestimoActionPerformed
        this.controller.atualizarDataDevolucao();
     
    }//GEN-LAST:event_TextDataEmprestimoActionPerformed

    private void ButVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButVoltarActionPerformed
        try {
            this.controller.navegarParaMenu();
        } catch (ParseException ex) {
            Logger.getLogger(TelaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                        // Fechar a tela
        dispose();
    }//GEN-LAST:event_ButVoltarActionPerformed


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButVoltar;
    private javax.swing.JLabel Logo;
    private javax.swing.JTextField TextDataDevolucao;
    private javax.swing.JTextField TextDataEmprestimo;
    private javax.swing.JTextField TextLivroId;
    private javax.swing.JTextField TextUsuarioId;
    private javax.swing.JButton butConfirmar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables

       public void exibeMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
    public JTextField getTextDataDevolucao() {
        return TextDataDevolucao;
    }

    public void setTextDataDevolucao(JTextField TextDataDevolucao) {
        this.TextDataDevolucao = TextDataDevolucao;
    }

    public JTextField getTextDataEmprestimo() {
        return TextDataEmprestimo;
    }

    public void setTextDataEmprestimo(JTextField TextDataEmprestimo) {
        this.TextDataEmprestimo = TextDataEmprestimo;
    }

    public JTextField getTextLivroId() {
        return TextLivroId;
    }

    public void setTextLivroId(JTextField TextLivroId) {
        this.TextLivroId = TextLivroId;
    }

    public JTextField getTextUsuarioId() {
        return TextUsuarioId;
    }

    public void setTextUsuarioId(JTextField TextUsuarioId) {
        this.TextUsuarioId = TextUsuarioId;
    }

 


}

