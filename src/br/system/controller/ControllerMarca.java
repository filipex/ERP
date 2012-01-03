
package br.system.controller;

import br.system.DAO.FactoryDAO;
import br.system.DAO.MarcaDAO;
import br.system.bean.Marca;
import br.system.exceptions.MyHibernateException;
import br.system.interfaces.IGeneric;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 25/12/2011 12:46
 */

public class ControllerMarca implements IGeneric<Marca> {

    private MarcaDAO daoMarca;
    private FactoryDAO daoFactory;

    public ControllerMarca() {
        daoFactory = new FactoryDAO();
        daoMarca = daoFactory.getMarcaDAO();

        if(!daoFactory.hasTransaction()) daoFactory.beginTransaction();
    }

    // Aplicar as regras de negócio aqui
    public void salvar(Marca object) {
        try {
            daoMarca.salvar(object);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public void excluir(Marca object) throws HibernateException {
        try {
            daoMarca.excluir(object);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public List<Marca> selecionarTodos() throws HibernateException {
        try {
            return daoMarca.selecionarTodos();
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

    public Marca selecionarPorId(Long value) throws HibernateException {
        try {
            return daoMarca.selecionarPorId(value);
        } catch (MyHibernateException e) {
            throw new MyHibernateException(e.getMotivo(), e.getErro());
        }
    }

}
