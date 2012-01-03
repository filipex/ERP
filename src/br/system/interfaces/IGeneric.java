
package br.system.interfaces;

import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 22/12/2011 23:12
 */

public interface IGeneric<O> {

    public void salvar(O object) throws HibernateException;

    public void excluir(O object) throws HibernateException;

    public List<O> selecionarTodos() throws HibernateException;

    //public DefaultComboBoxModel selectAllCombo() throws HibernateException;

    public O selecionarPorId(final Long value) throws HibernateException;

    //public List between(String parametro, String order, Date data_inicial, Date data_final);

    //public void abort();

    //public void close();

}
