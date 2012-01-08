
package br.system.view;

import javax.swing.UIManager;

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

         new tl_principal().setVisible(true);
    }

}
