/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Movie;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @since 09/11/2013
 * @author jleme
 */
public class MovieDAOImpl implements MovieDAO {

    public List<Movie> lista = new ArrayList<Movie>();
    public Movie movie = new Movie();

    public List<Movie> getLista() {
        return lista;
    }

    public void setLista(List<Movie> lista) {
        this.lista = lista;
    }

    @Override
    public List<Movie> getMovies() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        lista = session.createQuery("from Movie where usuario_nome like '%ulio%' order by nome ASC").list();

        t.commit();
        return lista;

    }

    @Override
    public List<Movie> getMovieSelected(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        lista = session.createQuery("from Movie where id=" + id + "order by nome ASC").list();

        t.commit();
        return lista;
    }

    @Override
    public void update(Movie movie) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.update(movie);

        t.commit();
    }

    @Override
    public List<Movie> getRanking() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        lista = session.createQuery("from Movie where usuario_nome like '%ulio%' order by voto DESC").list();

        t.commit();
        return lista;
    }

    @Override
    public List<Movie> getRankingGeral() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        lista = session.createQuery("from Movie order by voto DESC").list();

        t.commit();
        return lista;
    }
}
