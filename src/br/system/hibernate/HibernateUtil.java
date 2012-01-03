
package br.system.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 28/11/2011 23:03
 */

public class HibernateUtil {

    private static SessionFactory SESSION_FACTORY;

    static {
        SESSION_FACTORY = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public static Session getSession() {
        return SESSION_FACTORY.openSession();
    }

}
