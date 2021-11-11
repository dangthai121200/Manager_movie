/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DaoMovie;
import dao.DaoMovieAdmin;
import entity.MovieAdmin;
import imp.IAction;
import java.util.List;
import util.HibernateMovie;

/**
 *
 * @author gaone
 */
public class ModelMovieAdmin implements IAction<MovieAdmin> {
    private DaoMovieAdmin daoMovieAdmin;

    public ModelMovieAdmin() {
        daoMovieAdmin=new DaoMovieAdmin(HibernateMovie.openSession());
    }
    
    
    @Override
    public List<MovieAdmin> getAll() {
        return daoMovieAdmin.getAll();
    }

    @Override
    public MovieAdmin findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(MovieAdmin object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(MovieAdmin object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(MovieAdmin object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
