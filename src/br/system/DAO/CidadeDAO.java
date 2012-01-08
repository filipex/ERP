
package br.system.DAO;

import br.system.bean.Cidade;
import br.system.exceptions.MyHibernateException;
import br.system.interfaces.IGeneric;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import static br.system.tools.Constantes.PARAMETRO_ID_CIDADE;
import static br.system.tools.Constantes.ERRO_INSERIR;
import static br.system.tools.Constantes.ERRO_EXCLUIR;
import static br.system.tools.Constantes.ERRO_PESQUISAR;
import static br.system.tools.Constantes.ERRO_LISTAR;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 22/12/2011 23:11
 */

public class CidadeDAO implements IGeneric<Cidade> {

    private Session session;

    public CidadeDAO(Session session) {
        this.session = session;
    }

    public void salvar(Cidade object) throws HibernateException {
        try {
            session.saveOrUpdate(object);
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_INSERIR, e.getMessage());
        }
    }

    public void excluir(Cidade object) throws HibernateException {
        try {
            session.delete(object);
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_EXCLUIR, e.getMessage());
        }
    }

    public List<Cidade> selecionarTodos() throws HibernateException {
        try {
            Criteria criteria = session.createCriteria(Cidade.class);
            return criteria.list();
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_LISTAR, e.getMessage());
        }
    }

    public Cidade selecionarPorId(Long value) throws HibernateException {
        try {
            Criteria criteria = session.createCriteria(Cidade.class);
            criteria.add(Restrictions.ge(PARAMETRO_ID_CIDADE, value));
            return (Cidade) criteria.uniqueResult();
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_PESQUISAR, e.getMessage());
        }
    }

}
