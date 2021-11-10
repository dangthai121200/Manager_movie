/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DaoMovie;
import entity.Movie;
import imp.IAction;
import java.util.List;
import org.hibernate.Session;
import util.HibernateMovie;

/**
 *
 * @author gaone
 */
public class ModelMovie implements IAction<Movie>  {
    private DaoMovie daoMovie;
    

    public ModelMovie() {
        daoMovie=new DaoMovie(HibernateMovie.openSession());  
    }

    @Override
    public List<Movie> getAll() {
        return daoMovie.getAll();
    }

    @Override
    public Movie findById(int id) {
        return daoMovie.findById(id);
    }

    @Override
    public void delete(Movie object) {
        daoMovie.delete(object);
    }

    @Override
    public void update(Movie object) {
        daoMovie.update(object);
    }

    @Override
    public void add(Movie object) {
        daoMovie.add(object);
    }
    
}
