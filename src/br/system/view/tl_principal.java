/*
 * tl_principal.java
 *
 * Created on 08/01/2012, 09:59:52
 */

package br.system.view;

import br.system.tools.ConfigurarFormulario;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 08/01/2012 09:59:52
 */
public class tl_principal extends javax.swing.JFrame {

    private ConfigurarFormulario configurar;

    public tl_principal() {
        initComponents();

        configurar = new ConfigurarFormulario(this);

        // Essas informações serão buscadas da base de dados
        lbUsuario.setText("Usuário Logado: Teste");
        lbVersao.setText("Versão: Sistema Gerenciador 1.0");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tbStatus = new javax.swing.JToolBar();
        lbUsuario = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        lbVersao = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mSistema = new javax.swing.JMenu();
        miSair = new javax.swing.JMenuItem();
        mCadastro = new javax.swing.JMenu();
        miUsuario = new javax.swing.JMenuItem();
        miRelatorios = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Gerencial");

        tbStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tbStatus.setRollover(true);

        lbUsuario.setText("Usuario Logado");
        tbStatus.add(lbUsuario);
        tbStatus.add(jSeparator1);

        lbVersao.setText("Versão do Sistema");
        tbStatus.add(lbVersao);

        mSistema.setText("Sistema");

        miSair.setText("Sair");
        miSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSairActionPerformed(evt);
            }
        });
        mSistema.add(miSair);

        jMenuBar1.add(mSistema);

        mCadastro.setText("Cadastro");

        miUsuario.setText("Usuário");
        miUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUsuarioActionPerformed(evt);
            }
        });
        mCadastro.add(miUsuario);

        jMenuBar1.add(mCadastro);

        miRelatorios.setText("Relatórios");
        jMenuBar1.add(miRelatorios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(485, Short.MAX_VALUE)
                .addComponent(tbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miSairActionPerformed

    private void miUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUsuarioActionPerformed
        new tl_usuario().setVisible(true);
    }//GEN-LAST:event_miUsuarioActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tl_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JLabel lbVersao;
    private javax.swing.JMenu mCadastro;
    private javax.swing.JMenu mSistema;
    private javax.swing.JMenu miRelatorios;
    private javax.swing.JMenuItem miSair;
    private javax.swing.JMenuItem miUsuario;
    private javax.swing.JToolBar tbStatus;
    // End of variables declaration//GEN-END:variables

}
