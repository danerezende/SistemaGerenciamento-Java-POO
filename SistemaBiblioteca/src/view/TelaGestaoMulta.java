package view;

import Controller.TelaGestaoMultaController;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;


public class TelaGestaoMulta extends javax.swing.JFrame {

        private final TelaGestaoMultaController controller;

    
    public TelaGestaoMulta() {
        initComponents();
        controller = new TelaGestaoMultaController(this); //controller
        setLocationRelativeTo(null); // Centraliza a janela na tela
        this.setTitle("Sistema Biblioteca - Listagem Livros"); // Define o título
        iniciar();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ButVoltar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        butAtualizar = new javax.swing.JButton();
        LabelGestaoMultas = new javax.swing.JLabel();
        painel = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Multa", "ID Usuário", "Valor", "Data Multa", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 740, 390));

        ButVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/icons8-sair-24.png"))); // NOI18N
        ButVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(ButVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 610, 20, 20));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/log_menor.png"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, -1, 30));

        butAtualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butAtualizar.setText("Atualizar Multa");
        butAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAtualizarActionPerformed(evt);
            }
        });
        getContentPane().add(butAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 590, 150, 30));

        LabelGestaoMultas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LabelGestaoMultas.setText("Gestão de Multas");
        getContentPane().add(LabelGestaoMultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, -1, -1));

        painel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        painel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/fundo1.png"))); // NOI18N
        painel.setText("Gestão de Multas");
        getContentPane().add(painel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 880, 580));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/book1.jpg"))); // NOI18N
        background.setText("jLabel3");
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1271, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void butAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAtualizarActionPerformed
            this.controller.excluirMulta();
    }//GEN-LAST:event_butAtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaGestaoMulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGestaoMulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGestaoMulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGestaoMulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaGestaoMulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButVoltar;
    private javax.swing.JLabel LabelGestaoMultas;
    private javax.swing.JLabel background;
    private javax.swing.JButton butAtualizar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel painel;
    // End of variables declaration//GEN-END:variables
   
    private void iniciar() {
        this.controller.carregarTabela(jTable1);
    }

    public JTable getjTable1() {
        return jTable1;
    }

    public void setjTable1(JTable jTable1) {
        this.jTable1 = jTable1;
    }
    


}
