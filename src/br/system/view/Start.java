
package br.system.view;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import static br.system.tools.MyConstants.MENSAGEM_ERRO;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 25/12/2011 18:30
 */

public class Start {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) { }

        /*
         * Informar aqui qual a tela que será inicializada por padrão,
         * no qual será pega o Look And Feel do sistema operacional.
         */

        /*MyJOptionPane my = new MyJOptionPane(null, true);
        try {
            int x = 100/0;
        } catch (Exception e) {
            my.showError("Testando mensagem de erro.", e, MENSAGEM_ERRO);
            e.printStackTrace();
        }*/
    }

}
