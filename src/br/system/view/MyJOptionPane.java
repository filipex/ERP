/*
 * MyJOptionPane.java
 *
 * Created on 25/12/2011, 15:27:22
 */

package br.system.view;

import br.system.exceptions.MyFormatException;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import javax.swing.ImageIcon;

import static br.system.tools.Constantes.MENSAGEM_ATENCAO;
import static br.system.tools.Constantes.MENSAGEM_ERRO;
import static br.system.tools.Constantes.MENSAGEM_INFORMACAO;
import static br.system.tools.Constantes.MENSAGEM_QUESTAO;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 25/12/2011 15:27
 */

public class MyJOptionPane extends javax.swing.JDialog {

    private String mensagem;
    private String caminho_icone;
    private Exception exception;
    private int tipoMensagem;
    private MyFormatException myFormat;

    public MyJOptionPane(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        myFormat = new MyFormatException();
        lblIcone.setText("");
        ocultarLog();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOk = new javax.swing.JButton();
        btnDetalhes = new javax.swing.JButton();
        lblMensagem = new javax.swing.JLabel();
        lblIcone = new javax.swing.JLabel();
        spLog = new javax.swing.JScrollPane();
        taLog = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Atenção");

        btnOk.setText("OK");
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnDetalhes.setText("Detalhes");
        btnDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalhesActionPerformed(evt);
            }
        });

        lblMensagem.setText("Mensagem");

        lblIcone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcone.setText("Icone");

        spLog.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        taLog.setColumns(20);
        taLog.setEditable(false);
        taLog.setRows(5);
        spLog.setViewportView(taLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblIcone, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addComponent(spLog, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIcone, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnDetalhes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spLog, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalhesActionPerformed
        if(spLog.isVisible()) ocultarLog();
        else exibirLog();
    }//GEN-LAST:event_btnDetalhesActionPerformed
   
    private void ocultarLog() {
        spLog.setVisible(false);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //this.setSize((dim.width / 2) - 200, ((dim.height - spLog.getHeight()) / 2) - 150);
        this.setSize((dim.width / 2) - 300, ((dim.height - spLog.getHeight()) / 2) - 180);
    }

    private void exibirLog() {
        spLog.setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((dim.width / 2) - 300, ((dim.height + spLog.getHeight()) / 2) - 100);
    }

    private void gerarMensagem() {
        lblIcone.setIcon(new ImageIcon(this.caminho_icone));
        lblMensagem.setText(mensagem);
        taLog.setText(myFormat.format(exception));

        this.setVisible(true);
    }

    private void selecionarIcone() {
        switch(this.tipoMensagem) {
            case MENSAGEM_ATENCAO: {
                caminho_icone = "src/br/system/view/icones/Warning.png";
                break;
            }

            case MENSAGEM_ERRO: {
                caminho_icone = "src/br/system/view/icones/Delete.png";
                break;
            }

            case MENSAGEM_INFORMACAO: {

                break;
            }

            case MENSAGEM_QUESTAO: {

                break;
            }
        }
    }

    public void showError(String mensagem, Exception exception, int tipoMensagem) {
        this.mensagem = mensagem;
        this.exception = exception;
        this.tipoMensagem = tipoMensagem;

        selecionarIcone();
        gerarMensagem();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MyJOptionPane dialog = new MyJOptionPane(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalhes;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel lblIcone;
    private javax.swing.JLabel lblMensagem;
    private javax.swing.JScrollPane spLog;
    private javax.swing.JTextArea taLog;
    // End of variables declaration//GEN-END:variables

}
