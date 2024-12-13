package view;

import Controller.TelaDevolucaoController;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Controller.Helper.TelaDevolucaoHelper;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TelaDevolucao extends javax.swing.JFrame {
    
    private final TelaDevolucaoController controller;  


    public TelaDevolucao() {
        initComponents();
        controller = new TelaDevolucaoController(this); //controller
        this.setTitle("Sistema Biblioteca - Devolução"); // Define o título
        setLocationRelativeTo(null); // Centraliza a janela na tela

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        TextMulta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ButVoltar = new javax.swing.JButton();
        TextUsuarioId = new javax.swing.JTextField();
        TextDataEmprestimo = new javax.swing.JTextField();
        TextDataDevolucao = new javax.swing.JTextField();
        TextLivroId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Confirmar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 550, 130, 30));

        TextMulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextMultaActionPerformed(evt);
            }
        });
        getContentPane().add(TextMulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, 160, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/log_menor.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 160, -1, 30));

        ButVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/icons8-sair-24.png"))); // NOI18N
        ButVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(ButVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 590, 20, 20));

        TextUsuarioId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextUsuarioIdActionPerformed(evt);
            }
        });
        getContentPane().add(TextUsuarioId, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 160, -1));
        getContentPane().add(TextDataEmprestimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, 160, -1));

        TextDataDevolucao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextDataDevolucaoActionPerformed(evt);
            }
        });
        getContentPane().add(TextDataDevolucao, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, 160, -1));
        getContentPane().add(TextLivroId, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 160, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Multa");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 480, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Data Devolução");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 430, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Código Livro");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Id Usuário");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Data Empréstimo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Devolução Empréstimo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 210, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/fundo1.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 430, 490));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/book1.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, -1));

        jButton2.setText("jButton2");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 510, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (TextLivroId.getText().isEmpty() || 
            TextUsuarioId.getText().isEmpty() || 
            TextDataEmprestimo.getText().isEmpty() || 
            TextDataDevolucao.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            this.controller.registrarDevolucao();
        } catch (ParseException ex) {
            Logger.getLogger(TelaDevolucao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(TextLivroId.getText());//codigo livro
        System.out.println(TextUsuarioId.getText());//codigo usuario
        System.out.println(TextDataEmprestimo.getText());//
        System.out.println(TextDataDevolucao.getText());//
        System.out.println(TextMulta.getText());//    }                                        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TextUsuarioIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextUsuarioIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextUsuarioIdActionPerformed

    private void TextMultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextMultaActionPerformed
    }//GEN-LAST:event_TextMultaActionPerformed

    private void ButVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButVoltarActionPerformed
        try {
            this.controller.navegarParaMenu();
        } catch (ParseException ex) {
            Logger.getLogger(TelaDevolucao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                        // Fechar a tela
        dispose();
    }//GEN-LAST:event_ButVoltarActionPerformed

    private void TextDataDevolucaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextDataDevolucaoActionPerformed

      
    }//GEN-LAST:event_TextDataDevolucaoActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDevolucao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDevolucao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButVoltar;
    private javax.swing.JTextField TextDataDevolucao;
    private javax.swing.JTextField TextDataEmprestimo;
    private javax.swing.JTextField TextLivroId;
    private javax.swing.JTextField TextMulta;
    private javax.swing.JTextField TextUsuarioId;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
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
    
           
   //get and set
    
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

    public JTextField getTextMulta() {
        return TextMulta;
    }

    public void setTextMulta(JTextField TextMulta) {
        this.TextMulta = TextMulta;
    }

    public JTextField getTextUsuarioId() {
        return TextUsuarioId;
    }

    public void setTextUsuarioId(JTextField TextUsuarioId) {
        this.TextUsuarioId = TextUsuarioId;
    }


}
