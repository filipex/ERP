
package br.system.DAO;

import br.system.bean.SubGrupo;
import br.system.exceptions.MyHibernateException;
import br.system.interfaces.IGeneric;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import static br.system.tools.Constantes.PARAMETRO_ID_SUBGRUPO;
import static br.system.tools.Constantes.ERRO_INSERIR;
import static br.system.tools.Constantes.ERRO_EXCLUIR;
import static br.system.tools.Constantes.ERRO_PESQUISAR;
import static br.system.tools.Constantes.ERRO_LISTAR;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 24/12/2011 20:59
 */

public class SubGrupoDAO implements IGeneric<SubGrupo> {

    private Session session;

    public SubGrupoDAO(Session session) {
        this.session = session;
    }

    public void salvar(SubGrupo object) throws HibernateException {
        try {
            session.saveOrUpdate(object);
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_INSERIR, e.getMessage());
        }
    }

    public void excluir(SubGrupo object) throws HibernateException {
        try {
            session.delete(object);
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_EXCLUIR, e.getMessage());
        }
    }

    public List<SubGrupo> selecionarTodos() throws HibernateException {
        try {
            Criteria criteria = session.createCriteria(SubGrupo.class);
            return criteria.list();
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_LISTAR, e.getMessage());
        }
    }

    public SubGrupo selecionarPorId(Long value) throws HibernateException {
        try {
            Criteria criteria = session.createCriteria(SubGrupo.class);
            criteria.add(Restrictions.ge(PARAMETRO_ID_SUBGRUPO, value));
            return (SubGrupo) criteria.uniqueResult();
        } catch (HibernateException e) {
            throw new MyHibernateException(ERRO_PESQUISAR, e.getMessage());
        }
    }

}
