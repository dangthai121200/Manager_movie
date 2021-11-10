/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.DaoAdmin;
import entity.Admin;
import imp.IAction;
import util.HibernateMovie;
import imp.ICheckLogin;
import imp.ICheckName;
import java.util.List;
import imp.IListName;

/**
 *
 * @author gaone
 */
public class ModelAdmin implements ICheckLogin<Admin>,IAction<Admin>,IListName,ICheckName {
     private DaoAdmin daoAdmin;
    

    public ModelAdmin() {
        daoAdmin=new DaoAdmin(HibernateMovie.openSession());  
    }

    @Override
    public Admin checkLogin(String username, String password) {
        return daoAdmin.checkLogin(username, password);
    }

    @Override
    public List<Admin> getAll() {
        return daoAdmin.getAll();
    }

    @Override
    public Admin findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Admin object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Admin object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Admin object) {
       daoAdmin.add(object);
    }

    @Override
    public List<String> getAllUserName() {
        return daoAdmin.getAllUserName();
    }

    @Override
    public boolean checkName(String username) {
       return daoAdmin.checkName(username);
    }
}
