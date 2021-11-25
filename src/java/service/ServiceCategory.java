/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.DaoCategory;
import model.Category;
import imp.IAction;
import java.util.List;
import util.HibernateMovie;

/**
 *
 * @author gaone
 */
public class ServiceCategory implements IAction<Category>{
    private DaoCategory daoCategory;

    public ServiceCategory() {
        daoCategory=new DaoCategory(HibernateMovie.openSession());
    }
    

    @Override
    public List<Category> getAll() {
        return daoCategory.getAll();
    }

    @Override
    public Category findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Category object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Category object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Category object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
