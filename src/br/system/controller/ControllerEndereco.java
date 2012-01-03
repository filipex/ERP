
package br.system.controller;

import br.system.DAO.EnderecoDAO;
import br.system.DAO.FactoryDAO;
import br.system.bean.Endereco;
import br.system.exceptions.MyHibernateException;
import br.system.interfaces.IGeneric;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 25/12/2011 12:39
 */

public class ControllerEndereco implements IGeneric<Endereco> {

    private EnderecoDAO daoEndereco;
    private FactoryDAO daoFactory;

    public ControllerEndereco() {
        daoFactory = new FactoryDAO();
        daoEndereco = daoFactory.getEnderecoDAO();

        if(!daoFactory.hasTransaction()) daoFactory.beginTransaction();
    }

    // Aplicar as regras de negócio aqui
    public void salvar(Endereco object) {
        try {
            daoEndereco.salvar(object);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public void excluir(Endereco object) throws HibernateException {
        try {
            daoEndereco.excluir(object);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public List<Endereco> selecionarTodos() throws HibernateException {
        try {
            return daoEndereco.selecionarTodos();
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public Endereco selecionarPorId(Long value) throws HibernateException {
        try {
            return daoEndereco.selecionarPorId(value);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

}
