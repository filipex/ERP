
package br.system.controller;

import br.system.DAO.EmpresaDAO;
import br.system.DAO.FactoryDAO;
import br.system.bean.Empresa;
import br.system.exceptions.MyHibernateException;
import br.system.interfaces.IGeneric;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 25/12/2011 12:37
 */

public class ControllerEmpresa implements IGeneric<Empresa> {

    private EmpresaDAO daoEmpresa;
    private FactoryDAO daoFactory;

    public ControllerEmpresa() {
        daoFactory = new FactoryDAO();
        daoEmpresa = daoFactory.getEmpresaDAO();

        if(!daoFactory.hasTransaction()) daoFactory.beginTransaction();
    }

    // Aplicar as regras de negócio aqui
    public void salvar(Empresa object) {
        try {
            daoEmpresa.salvar(object);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public void excluir(Empresa object) throws HibernateException {
        try {
            daoEmpresa.excluir(object);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public List<Empresa> selecionarTodos() throws HibernateException {
        try {
            return daoEmpresa.selecionarTodos();
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public Empresa selecionarPorId(Long value) throws HibernateException {
        try {
            return daoEmpresa.selecionarPorId(value);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

}
