
package br.system.controller;

import br.system.DAO.ClienteDAO;
import br.system.DAO.FactoryDAO;
import br.system.bean.Cliente;
import br.system.exceptions.MyHibernateException;
import br.system.interfaces.IGeneric;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 24/12/2011 20:59
 */

public class ControllerCliente implements IGeneric<Cliente> {

    private ClienteDAO daoCliente;
    private FactoryDAO daoFactory;

    public ControllerCliente() {
        daoFactory = new FactoryDAO();
        daoCliente = daoFactory.getClienteDAO();

        if(!daoFactory.hasTransaction()) daoFactory.beginTransaction();
    }

    // Aplicar as regras de negócio aqui
    public void salvar(Cliente object) {
        try {
            daoCliente.salvar(object);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public void excluir(Cliente object) throws HibernateException {
        try {
            daoCliente.excluir(object);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public List<Cliente> selecionarTodos() throws HibernateException {
        try {
            return daoCliente.selecionarTodos();
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public Cliente selecionarPorId(Long value) throws HibernateException {
        try {
            return daoCliente.selecionarPorId(value);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    } 

}
