package view;

import Controller.TelaListagemLivrosController;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;


public class TelaListagemLivros extends javax.swing.JFrame {

        private final TelaListagemLivrosController controller;

    
    public TelaListagemLivros() {
        initComponents();
        controller = new TelaListagemLivrosController(this); //controller
        setLocationRelativeTo(null); // Centraliza a janela na tela
        this.setTitle("Sistema Biblioteca - Listagem Livros"); // Define o título
        iniciar();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButEditar = new javax.swing.JButton();
        ButExcluir = new javax.swing.JButton();
        ButVoltar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ButEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButEditar.setText("Editar");
        ButEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButEditarActionPerformed(evt);
            }
        });
        getContentPane().add(ButEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 620, 130, 30));

        ButExcluir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ButExcluir.setText("Excluir");
        ButExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(ButExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 620, 130, 30));

        ButVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/icons8-sair-24.png"))); // NOI18N
        ButVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(ButVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 660, 20, 20));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/log_menor.png"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, -1, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Listagem dos Livros");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 170, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Autor", "Categoria", "ISBN", "Ano", "Disponível"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 900, 410));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/fundo1.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 960, 670));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagem/book1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1281, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButVoltarActionPerformed
        try {
            this.controller.navegarParaMenu();
        } catch (ParseException ex) {
            Logger.getLogger(
                    TelaEmprestimo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                        // Fechar a tela
        dispose();
    }//GEN-LAST:event_ButVoltarActionPerformed

    private void ButEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButEditarActionPerformed
            this.controller.atualizarLivro();
    }//GEN-LAST:event_ButEditarActionPerformed

    private void ButExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButExcluirActionPerformed
            this.controller.excluirLivro();
    }//GEN-LAST:event_ButExcluirActionPerformed


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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaListagemLivros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaListagemLivros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButEditar;
    private javax.swing.JButton ButExcluir;
    private javax.swing.JButton ButVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
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
