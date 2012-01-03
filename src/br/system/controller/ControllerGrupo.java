
package br.system.controller;

import br.system.DAO.FactoryDAO;
import br.system.DAO.GrupoDAO;
import br.system.bean.Grupo;
import br.system.exceptions.MyHibernateException;
import br.system.interfaces.IGeneric;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 25/12/2011 12:41
 */

public class ControllerGrupo implements IGeneric<Grupo> {

    private GrupoDAO daoGrupo;
    private FactoryDAO daoFactory;

    public ControllerGrupo() {
        daoFactory = new FactoryDAO();
        daoGrupo = daoFactory.getGrupoDAO();

        if(!daoFactory.hasTransaction()) daoFactory.beginTransaction();
    }

    // Aplicar as regras de negócio aqui
    public void salvar(Grupo object) {
        try {
            daoGrupo.salvar(object);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public void excluir(Grupo object) throws HibernateException {
        try {
            daoGrupo.excluir(object);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public List<Grupo> selecionarTodos() throws HibernateException {
        try {
            return daoGrupo.selecionarTodos();
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public Grupo selecionarPorId(Long value) throws HibernateException {
        try {
            return daoGrupo.selecionarPorId(value);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

}
