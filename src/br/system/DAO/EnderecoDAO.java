
package br.system.DAO;


import br.system.bean.Endereco;
import br.system.exceptions.MyHibernateException;
import br.system.interfaces.IGeneric;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import static br.system.tools.MyConstants.PARAMETRO_ID_ENDERECO;
import static br.system.tools.MyConstants.ERRO_INSERIR;
import static br.system.tools.MyConstants.ERRO_EXCLUIR;
import static br.system.tools.MyConstants.ERRO_PESQUISAR;
import static br.system.tools.MyConstants.ERRO_LISTAR;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 24/12/2011 20:20
 */

public class EnderecoDAO implements IGeneric<Endereco> {

    private Session session;

    public EnderecoDAO(Session session) {
        this.session = session;
    }

    public void salvar(Endereco object) throws HibernateException {
        try {
            session.saveOrUpdate(object);
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_INSERIR, e.getMessage());
        }
    }

    public void excluir(Endereco object) throws HibernateException {
        try {
            session.delete(object);
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_EXCLUIR, e.getMessage());
        }
    }

    public List<Endereco> selecionarTodos() throws HibernateException {
        try {
            Criteria criteria = session.createCriteria(Endereco.class);
            return criteria.list();
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_LISTAR, e.getMessage());
        }
    }

    public Endereco selecionarPorId(Long value) throws HibernateException {
        try {
            Criteria criteria = session.createCriteria(Endereco.class);
            criteria.add(Restrictions.ge(PARAMETRO_ID_ENDERECO, value));
            return (Endereco) criteria.uniqueResult();
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_PESQUISAR, e.getMessage());
        }
    }

}
