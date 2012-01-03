
package br.system.DAO;


import br.system.bean.Marca;
import br.system.exceptions.MyHibernateException;
import br.system.interfaces.IGeneric;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import static br.system.tools.MyConstants.PARAMETRO_ID_MARCA;
import static br.system.tools.MyConstants.ERRO_INSERIR;
import static br.system.tools.MyConstants.ERRO_EXCLUIR;
import static br.system.tools.MyConstants.ERRO_PESQUISAR;
import static br.system.tools.MyConstants.ERRO_LISTAR;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 24/12/2011 20:59
 */

public class MarcaDAO implements IGeneric<Marca> {

    private Session session;

    public MarcaDAO(Session session) {
        this.session = session;
    }

    public void salvar(Marca object) throws HibernateException {
        try {
            session.saveOrUpdate(object);
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_INSERIR, e.getMessage());
        }
    }

    public void excluir(Marca object) throws HibernateException {
        try {
            session.delete(object);
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_EXCLUIR, e.getMessage());
        }
    }

    public List<Marca> selecionarTodos() throws HibernateException {
        try {
            Criteria criteria = session.createCriteria(Marca.class);
            return criteria.list();
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_LISTAR, e.getMessage());
        }
    }

    public Marca selecionarPorId(Long value) throws HibernateException {
        try {
            Criteria criteria = session.createCriteria(Marca.class);
            criteria.add(Restrictions.ge(PARAMETRO_ID_MARCA, value));
            return (Marca) criteria.uniqueResult();
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_PESQUISAR, e.getMessage());
        }
    }

}
