
package br.system.controller;

import br.system.DAO.FactoryDAO;
import br.system.DAO.UsuarioDAO;
import br.system.bean.Usuario;
import br.system.exceptions.MyHibernateException;
import br.system.interfaces.IGeneric;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 25/12/2011 12:51
 */

public class ControllerUsuario implements IGeneric<Usuario> {

    private UsuarioDAO daoUsuario;
    private FactoryDAO daoFactory;

    public ControllerUsuario() {
        daoFactory = new FactoryDAO();
        daoUsuario = daoFactory.getUsuarioDAO();

        if(!daoFactory.hasTransaction()) daoFactory.beginTransaction();
    }

    // Aplicar as regras de negócio aqui
    public void salvar(Usuario object) {
        try {
            daoUsuario.salvar(object);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public void excluir(Usuario object) throws HibernateException {
        try {
            daoUsuario.excluir(object);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public List<Usuario> selecionarTodos() throws HibernateException {
        try {
            return daoUsuario.selecionarTodos();
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public Usuario selecionarPorId(Long value) throws HibernateException {
        try {
            return daoUsuario.selecionarPorId(value);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }


}
