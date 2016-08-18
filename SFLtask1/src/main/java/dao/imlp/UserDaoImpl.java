/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.imlp;

import utils.HibernateUtil;
import dao.UserDao;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import domains.User;

/**
 *
 * @author ScatUm
 */
public class UserDaoImpl implements UserDao{

     @Override
    public void addUser(User user) throws SQLException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if((session!=null) && (session.isOpen())) {
           // session.close();
        }
        }
    }

    @Override
    public void deleteUser(User user) throws SQLException {
        Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if((session!=null) && (session.isOpen())) {
           // session.close();
        }
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User getUser(int id) throws SQLException {
            User result = null;
             Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            result = (User)session.load(User.class, id);
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if((session!=null) && (session.isOpen())) {
                
           // session.close();
        }
        }
            
        return result;

    }
    
      @Override
    public User LoginUser(String email, String password) throws SQLException {
  User result = null;
             Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("u_password", password));
            criteria.add(Restrictions.eq("u_email", email));
            List<User> users = criteria.list();
            
            result = users.get(0);
           //  result = (User) query.list();
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if((session!=null) && (session.isOpen())) {
          //  session.close();
        }
        }
            
        return result;
        
    }
    
       @Override
    public List<User> getFiltrUsers() throws SQLException {
  List<User> result = null;
             Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("u_is_admin", false));
            result= criteria.list();
           
            
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if((session!=null) && (session.isOpen())) {
          //  session.close();
        }
        }
            
        return result;
        
    }


    @Override
    public List<User> getUsers() throws SQLException {
        List<User> users = null;
        
           Session session = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
           users =  session.createCriteria(User.class).list();
        }catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if((session!=null) && (session.isOpen())) {
          // session.close();
        }
        }
        
        return users;
    }
    
}
