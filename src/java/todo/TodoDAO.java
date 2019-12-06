/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

/**
 *
 * @author Admin
 */
public class TodoDAO {
    public Todo getTodo(long id){
        Transaction transaction = null;
        Todo todo = null;
        
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            todo = (Todo) session.get(Todo.class, id);
            
            transaction.commit();
        }
        catch(HibernateException ex){
            if(transaction != null){
                transaction.rollback();
            }
            System.err.println(ex);
        }
        
        return todo;
    }
    
    public List<Todo> getAllTodos(String username){
        List<Todo> listOfTodos = null;
        Transaction transaction = null;
        
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            listOfTodos = session.createQuery(" from Todo where username = '" + username + "'").list();
            
            transaction.commit();
        }
        catch(HibernateException ex){
            if(transaction != null){
                transaction.rollback();
            }
            System.err.println(ex);
        }
        
        return listOfTodos;
    }
    
    public boolean saveNewTodo(Todo todo){
        Transaction transaction = null;
        
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            session.save(todo);
            
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
    
    public boolean deleteTodo(long id){
        Transaction transaction = null;
        
        
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            Todo todo = (Todo) session.get(Todo.class, id);
            if(todo != null){
                session.delete(todo);            
            }
            
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
    
    public boolean updateTodo(Todo todo){
        Transaction transaction = null;       
        
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            session.update(todo);
            
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
