
package br.system.DAO;

import br.system.bean.Cliente;
import br.system.exceptions.MyHibernateException;
import br.system.interfaces.IGeneric;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import static br.system.tools.Constantes.PARAMETRO_ID_CLIENTE;
import static br.system.tools.Constantes.ERRO_INSERIR;
import static br.system.tools.Constantes.ERRO_EXCLUIR;
import static br.system.tools.Constantes.ERRO_PESQUISAR;
import static br.system.tools.Constantes.ERRO_LISTAR;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 24/12/2011 20:12
 */

public class ClienteDAO implements IGeneric<Cliente> {

    private Session session;

    public ClienteDAO(Session session) {
        this.session = session;
    }

    public void salvar(Cliente object) throws HibernateException {
        try {
            session.saveOrUpdate(object);
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_INSERIR, e.getMessage());
        }
    }

    public void excluir(Cliente object) throws HibernateException {
        try {
            session.delete(object);
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_EXCLUIR, e.getMessage());
        }
    }

    public List<Cliente> selecionarTodos() throws HibernateException {
        try {
            Criteria criteria = session.createCriteria(Cliente.class);
            return criteria.list();
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_LISTAR, e.getMessage());
        }
    }

    public Cliente selecionarPorId(Long value) throws HibernateException {
        try {
            Criteria criteria = session.createCriteria(Cliente.class);
            criteria.add(Restrictions.ge(PARAMETRO_ID_CLIENTE, value));
            return (Cliente) criteria.uniqueResult();
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_PESQUISAR, e.getMessage());
        }
    }

}
