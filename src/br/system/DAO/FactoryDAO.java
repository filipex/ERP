
package br.system.DAO;

import br.system.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 22/12/2011 23:20
 */

public class FactoryDAO {

    private final Session SESSION;
    private Transaction transaction;

    public FactoryDAO() {
        this.SESSION = HibernateUtil.getSession();
    }

    public void beginTransaction() {
        this.transaction = SESSION.beginTransaction();
    }

    public void commit() {
        this.transaction.commit();
        this.transaction = null;
    }

    public void rollback() {
        this.transaction.rollback();
        this.transaction = null;
    }

    public boolean hasTransaction() {
        return this.transaction != null;
    }

    public boolean isOpen() {
        return this.SESSION.isOpen();
    }

    public boolean isConnected() {
        return this.SESSION.isConnected();
    }

    public void disconnect() {
        this.SESSION.disconnect();
    }

    public void close() {
        this.SESSION.close();
    }

    public void flush() {
        this.SESSION.flush();
    }

    public CidadeDAO getBancoDAO() {
        return new CidadeDAO(SESSION);
    }

    public ClienteDAO getClienteDAO() {
        return new ClienteDAO(SESSION);
    }

    public EmpresaDAO getEmpresaDAO() {
        return new EmpresaDAO(SESSION);
    }

    public EnderecoDAO getEnderecoDAO() {
        return new EnderecoDAO(SESSION);
    }

    public GrupoDAO getGrupoDAO() {
        return new GrupoDAO(SESSION);
    }

    public MarcaDAO getMarcaDAO() {
        return new MarcaDAO(SESSION);
    }

    public SubGrupoDAO getSubGrupoDAO() {
        return new SubGrupoDAO(SESSION);
    }

    public UsuarioDAO getUsuarioDAO() {
        return new UsuarioDAO(SESSION);
    }
    
}