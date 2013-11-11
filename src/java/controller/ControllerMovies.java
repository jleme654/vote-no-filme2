/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MovieDAO;
import dao.MovieDAOImpl;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import model.Movie;

/**
 *
 * @since 29/01/2013
 * @author jleme
 */
@ManagedBean
@SessionScoped
public class ControllerMovies implements Serializable {

    private DataModel listMovies;
  
    public DataModel getListMovies() {
        return listMovies;
    }

    public void setListMovies(DataModel listMovies) {
        this.listMovies = listMovies;
    }

    public DataModel getMovies() {
        List<Movie> lista = new MovieDAOImpl().getMovies();
        listMovies = new ListDataModel(lista);

        return listMovies;
    }

    public DataModel getRanking() {
        List<Movie> lista = new MovieDAOImpl().getRanking();
        listMovies = new ListDataModel(lista);

        return listMovies;
    }

    public DataModel getRankingGeral() {
        List<Movie> lista = new MovieDAOImpl().getRankingGeral();
        listMovies = new ListDataModel(lista);

        return listMovies;
    }

    public void redirect(Integer id) {
        System.out.println("ID DO FILME:" + id);

        listMovies = getMovieSelected(id);

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("filmeEscolhido.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(ControllerMovies.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DataModel getMovieSelected(Integer id) {
        List<Movie> lista = new MovieDAOImpl().getMovieSelected(id);
        listMovies = new ListDataModel(lista);

        return listMovies;
    }

    public void votar(Movie movie) {
        MovieDAO dao = new MovieDAOImpl();
        System.out.println("VOTOS:" + movie.getVoto());
        movie.setVoto(movie.getVoto() + 1);
        dao.update(movie);
    }
}
