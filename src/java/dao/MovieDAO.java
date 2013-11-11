/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Movie;

/**
 *
 * @author jleme
 */
public interface MovieDAO {

    public List<Movie> getMovies();

    public List<Movie> getRanking();
    
    public List<Movie> getRankingGeral();

    public List<Movie> getMovieSelected(Integer id);

    public void update(Movie movie);
}
