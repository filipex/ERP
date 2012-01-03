
package br.system.controller;

import br.system.DAO.CidadeDAO;
import br.system.DAO.FactoryDAO;
import br.system.bean.Cidade;
import br.system.exceptions.MyHibernateException;
import br.system.interfaces.IGeneric;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 22/12/2011 23:05
 */

public class ControllerCidade implements IGeneric<Cidade> {

    private CidadeDAO daoCidade;
    private FactoryDAO daoFactory;

    public ControllerCidade() {
        daoFactory = new FactoryDAO();
        daoCidade = daoFactory.getBancoDAO();

        if(!daoFactory.hasTransaction()) daoFactory.beginTransaction();
    }

    // Aplicar as regras de negócio aqui
    public void salvar(Cidade object) {
        try {
            daoCidade.salvar(object);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public void excluir(Cidade object) throws HibernateException {
        try {
            daoCidade.excluir(object);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public List<Cidade> selecionarTodos() throws HibernateException {
        try {
            return daoCidade.selecionarTodos();
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public Cidade selecionarPorId(Long value) throws HibernateException {
        try {
            return daoCidade.selecionarPorId(value);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

}
