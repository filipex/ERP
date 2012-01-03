
package br.system.DAO;

import br.system.bean.Usuario;
import br.system.exceptions.MyHibernateException;
import br.system.interfaces.IGeneric;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import static br.system.tools.MyConstants.PARAMETRO_ID_USUARIO;
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

public class UsuarioDAO implements IGeneric<Usuario> {

    private Session session;

    public UsuarioDAO(Session session) {
        this.session = session;
    }

    public void salvar(Usuario object) throws HibernateException {
        try {
            session.saveOrUpdate(object);
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_INSERIR, e.getMessage());
        }
    }

    public void excluir(Usuario object) throws HibernateException {
        try {
            session.delete(object);
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_EXCLUIR, e.getMessage());
        }
    }

    public List<Usuario> selecionarTodos() throws HibernateException {
        try {
            Criteria criteria = session.createCriteria(Usuario.class);
            return criteria.list();
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_LISTAR, e.getMessage());
        }
    }

    public Usuario selecionarPorId(Long value) throws HibernateException {
        try {
            Criteria criteria = session.createCriteria(Usuario.class);
            criteria.add(Restrictions.ge(PARAMETRO_ID_USUARIO, value));
            return (Usuario) criteria.uniqueResult();
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_PESQUISAR, e.getMessage());
        }
    }

}
