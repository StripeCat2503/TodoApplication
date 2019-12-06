/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author Admin
 */
public class UserDAO {
    public User getUser(String username, String password){
        Transaction transaction = null;
        User user = null;
        
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            user = (User) session.get(User.class, username);
            if(user != null){
                if(user.getPassword().equals(password)){
                    return user;
                }
                else{
                    return null;
                }
            }
            
            transaction.commit();
        }
        catch(HibernateException ex){
            if(transaction != null){
                transaction.rollback();
            }
            System.err.println(ex);
        }
        
        return user;
        
    }
    
    public boolean saveNewUser(User user){
        Transaction transaction = null;
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            session.save(user);
            
            transaction.commit();
        }
        catch(HibernateException ex){
            if(transaction != null){
                transaction.rollback();
            }
            System.err.println(ex);
            
            return false;
        }
        
        return true;
    }
}
