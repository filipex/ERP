
package br.system.DAO;

import br.system.bean.Empresa;
import br.system.exceptions.MyHibernateException;
import br.system.interfaces.IGeneric;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import static br.system.tools.MyConstants.PARAMETRO_ID_EMPRESA;
import static br.system.tools.MyConstants.ERRO_INSERIR;
import static br.system.tools.MyConstants.ERRO_EXCLUIR;
import static br.system.tools.MyConstants.ERRO_PESQUISAR;
import static br.system.tools.MyConstants.ERRO_LISTAR;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 24/12/2011 20:16
 */

public class EmpresaDAO implements IGeneric<Empresa> {

    private Session session;

    public EmpresaDAO(Session session) {
        this.session = session;
    }

    public void salvar(Empresa object) throws HibernateException {
        try {
            session.saveOrUpdate(object);
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_INSERIR, e.getMessage());
        }
    }

    public void excluir(Empresa object) throws HibernateException {
        try {
            session.delete(object);
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_EXCLUIR, e.getMessage());
        }
    }

    public List<Empresa> selecionarTodos() throws HibernateException {
        try {
            Criteria criteria = session.createCriteria(Empresa.class);
            return criteria.list();
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_LISTAR, e.getMessage());
        }
    }

    public Empresa selecionarPorId(Long value) throws HibernateException {
        try {
            Criteria criteria = session.createCriteria(Empresa.class);
            criteria.add(Restrictions.ge(PARAMETRO_ID_EMPRESA, value));
            return (Empresa) criteria.uniqueResult();
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_PESQUISAR, e.getMessage());
        }
    }

}
