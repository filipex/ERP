
package br.system.exceptions;

import br.system.interfaces.IException;
import org.hibernate.HibernateException;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 24/12/2011 18:41
 */

public class MyHibernateException extends HibernateException implements IException {

    private String motivo;
    private String erro;

    public MyHibernateException(final String motivo, final String erro) {
        super(motivo + "\n\nErro: " + erro);

        this.motivo = motivo;
        this.erro = erro;
    }   

    public String getMotivo() {
        return motivo;
    }

    public String getErro() {
        return erro;
    }

}