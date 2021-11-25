/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import imp.IAction;
import model.Movie;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author gaone
 */
public class DaoMovie implements IAction<Movie>   {
    private Session session;

    public DaoMovie(Session session) {
        this.session = session;
    }

    @Override
    public List<Movie> getAll() {
        session.beginTransaction();
        List<Movie>movies=session.createQuery("from Movie").list();
        session.getTransaction().commit();
        return movies;
    }

    @Override
    public Movie findById(int id) {
        session.beginTransaction();
        Movie movie=(Movie) session.get(Movie.class, id);
        session.getTransaction().commit();
        return movie;
    }

    @Override
    public void delete(Movie object) {
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void update(Movie object) {
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void add(Movie object) {
       session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
    }
    
    
}
