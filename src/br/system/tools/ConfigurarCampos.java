
package br.system.tools;

import java.awt.Component;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 08/01/2012 10:29
 */
public class ConfigurarCampos {

    public ConfigurarCampos() {

    }

    public void limparCampos(JPanel pn) {

        for(int cont = 0; cont < pn.getComponentCount(); cont++) {
            Component comp = pn.getComponent(cont);

            if(comp instanceof JTextField) {
                JTextField tf = (JTextField) comp;
                tf.setText("");
            }

            if(comp instanceof JFormattedTextField) {
                JFormattedTextField tf = (JFormattedTextField) comp;
                tf.setText("");
            }

            if(comp instanceof JPasswordField) {
                JPasswordField tf = (JPasswordField) comp;
                tf.setText("");
            }
        }
    }

    public boolean verificarCamposEmBranco(JPanel pn) {

        for(int cont = 0; cont < pn.getComponentCount(); cont++) {
            Component comp = pn.getComponent(cont);

            if(comp instanceof JTextField) {
                JTextField tf = (JTextField) comp;

                if(tf.getText().isEmpty()) return true;
            }

            if(comp instanceof JFormattedTextField) {
                JFormattedTextField tf = (JFormattedTextField) comp;

                if(tf.getText().isEmpty()) return true;
            }

            if(comp instanceof JPasswordField) {
                JPasswordField tf = (JPasswordField) comp;

                String senha = new String(tf.getPassword());
                if(senha.isEmpty()) return true;
            }
        }

        return false;
    }

    public void habilitarCampos(JPanel pn, boolean habilitar) {

        for(int cont = 0; cont < pn.getComponentCount(); cont++) {
            Component comp = pn.getComponent(cont);

            if(comp instanceof JTextField) {
                JTextField tf = (JTextField) comp;

                tf.setEnabled(habilitar);
                System.out.println(tf.getName());
            }

            if(comp instanceof JFormattedTextField) {
                JFormattedTextField tf = (JFormattedTextField) comp;

                tf.setEnabled(habilitar);
                System.out.println(tf.getName());
            }

            if(comp instanceof JPasswordField) {
                JPasswordField tf = (JPasswordField) comp;

                tf.setEnabled(habilitar);
                System.out.println(tf.getName());
            }
        }
    }

}
