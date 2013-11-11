/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import model.Movie;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @since 29/01/2013
 * @author jleme
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                AnnotationConfiguration ac = new AnnotationConfiguration();
                /**
                 * ATENÇÃO AQUI: SEMPRE INICIALIZAR A CLASSE NA SESSION PARA
                 * MAPEAR A TABELA E SUAS COLUNAS
                 */
                ac.addAnnotatedClass(Movie.class);

                sessionFactory = ac.configure().buildSessionFactory();
            } catch (Throwable ex) {
                System.err.println("Initial SessionFactory creation failed." + ex);
                throw new ExceptionInInitializerError(ex);
            }
            return sessionFactory;
        } else {
            return sessionFactory;
        }

    }
}
