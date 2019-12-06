/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;


import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import todo.Todo;
import user.User;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Admin
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory;
   
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null){
            Configuration config = new Configuration();
            Properties settings = new Properties();
            
            // config database connection
            settings.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
            settings.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=TodoDB");
            settings.put(Environment.USER, "sa");
            settings.put(Environment.PASS, "123");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.SQLServer2005Dialect");
            settings.put(Environment.SHOW_SQL, "true");
            
            config.setProperties(settings);
            
            config.addAnnotatedClass(User.class);
            config.addAnnotatedClass(Todo.class);
            
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(config.getProperties()).build();
            
            sessionFactory = config.buildSessionFactory(serviceRegistry);
           
        }
        
        return sessionFactory;
    }
}
