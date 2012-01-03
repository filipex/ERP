
package br.system.DAO;

import br.system.bean.Grupo;
import br.system.exceptions.MyHibernateException;
import br.system.interfaces.IGeneric;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import static br.system.tools.MyConstants.PARAMETRO_ID_GRUPO;
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

public class GrupoDAO implements IGeneric<Grupo> {

    private Session session;

    public GrupoDAO(Session session) {
        this.session = session;
    }

    public void salvar(Grupo object) throws HibernateException {
        try {
            session.saveOrUpdate(object);
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_INSERIR, e.getMessage());
        }
    }

    public void excluir(Grupo object) throws HibernateException {
        try {
            session.delete(object);
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_EXCLUIR, e.getMessage());
        }
    }

    public List<Grupo> selecionarTodos() throws HibernateException {
        try {
            Criteria criteria = session.createCriteria(Grupo.class);
            return criteria.list();
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_LISTAR, e.getMessage());
        }
    }

    public Grupo selecionarPorId(Long value) throws HibernateException {
        try {
            Criteria criteria = session.createCriteria(Grupo.class);
            criteria.add(Restrictions.ge(PARAMETRO_ID_GRUPO, value));
            return (Grupo) criteria.uniqueResult();
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_PESQUISAR, e.getMessage());
        }
    }

}
