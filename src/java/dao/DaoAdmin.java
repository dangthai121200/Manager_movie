/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Admin;
import imp.IAction;
import java.sql.ResultSet;
import java.util.List;
import org.hibernate.Session;
import util.HibernateMovie;
import imp.ICheckLogin;
import imp.ICheckName;
import imp.IListName;

/**
 *
 * @author gaone
 */
public class DaoAdmin implements ICheckLogin<Admin>,IAction<Admin>,IListName,ICheckName {
     private Session session;

    public DaoAdmin(Session session) {
        this.session = session;
    }
    
    @Override
    public Admin checkLogin(String username, String password) {
        List<Admin> admins=null;
        session.beginTransaction();
        admins = session.createQuery("from Admin where username=:username").setParameter("username", username).list();
       session.getTransaction().commit();
        if(admins.size()>0&&admins.get(0).getPassword().equals(password)){
            return  admins.get(0);
        }
        return null;
    } 
    @Override
    public List<Admin> getAll() {
        session.beginTransaction();
        List<Admin> admins = session.createQuery("from Admin").list();
        session.getTransaction().commit();
        return admins;
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
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<String> getAllUserName() {
        session.beginTransaction();
        List<String> listUserNamse = session.createQuery("select username from Admin").list();
        session.getTransaction().commit();
        return listUserNamse;
    }
//    public static void main(String[] args) {
//        List<String> admins=new DaoAdmin(HibernateMovie.openSession()).getAllUserName();
//        System.out.println(admins.toString());
//    }

    @Override
    public boolean checkName(String username) {
        List<String> names=null;
        session.beginTransaction();
        names = session.createQuery("select username from Admin where username=:username").setParameter("username", username).list();
       session.getTransaction().commit();
        if(names.size()==0){
            return  true;
        }
        return false;
    }
}
