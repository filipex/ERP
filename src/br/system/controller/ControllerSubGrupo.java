
package br.system.controller;

import br.system.DAO.FactoryDAO;
import br.system.DAO.SubGrupoDAO;
import br.system.bean.SubGrupo;
import br.system.exceptions.MyHibernateException;
import br.system.interfaces.IGeneric;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 25/12/2011 12:49
 */

public class ControllerSubGrupo implements IGeneric<SubGrupo> {

    private SubGrupoDAO daoSubGrupo;
    private FactoryDAO daoFactory;

    public ControllerSubGrupo() {
        daoFactory = new FactoryDAO();
        daoSubGrupo = daoFactory.getSubGrupoDAO();

        if(!daoFactory.hasTransaction()) daoFactory.beginTransaction();
    }

    // Aplicar as regras de negócio aqui
    public void salvar(SubGrupo object) {
        try {
            daoSubGrupo.salvar(object);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public void excluir(SubGrupo object) throws HibernateException {
        try {
            daoSubGrupo.excluir(object);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public List<SubGrupo> selecionarTodos() throws HibernateException {
        try {
            return daoSubGrupo.selecionarTodos();
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public SubGrupo selecionarPorId(Long value) throws HibernateException {
        try {
            return daoSubGrupo.selecionarPorId(value);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

}
