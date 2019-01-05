/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.metamodel.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author sept
 * @param <T> cualquier tipo que reciban las funciones para manipulacion de datos
 * 
 */
public class DAOBase <T> {
    
    private static SessionFactory sessionFactory;
    
    public DAOBase(){
        
    }
    
    /**
     * @return session ya iniciada 
     */
    public static Session getSession(){
        if(sessionFactory==null){
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // obtiene los valores de hibernate.cfg.xml
                .build();
            sessionFactory = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory();
        }
        return sessionFactory.openSession();
    }
    
    public static void closeSession(){
        sessionFactory.close();
    }
    
    /**
     * @param <T> tipo de dato del objeto
     * @param session session ya iniciada
     * @param object objeto a eliminar
     */
    public static <T> void insert(Session session, T object){
        session.save(object);
    }
    
    /**
     * @param <T> tipo de dato del objeto
     * @param session session ya iniciada
     * @param object objeto a eliminar
     */
    public static <T> void update(Session session, T object){
        session.update(object);
    }
    
    /**
     * @param <T> tipo de dato del objeto
     * @param session session ya iniciada
     * @param object objeto a eliminar
     */
    public static <T> void delete(Session session, T object){
        session.delete(object);
    }
    
    /**
     * @see DAOBase.getSession()
     * @param <T> tipo de dato del objeto
     * @param object objeto a eliminar
     */
    public static <T> void insert(T object){
        getSession().save(object);
    }
    
    /**
     * @see DAOBase.getSession()
     * @param <T> tipo de dato del objeto
     * @param object objeto a eliminar
     */
    public static <T> void update(T object){
        getSession().update(object);
    }
    
    /**
     * @see DAOBase.getSession()
     * @param <T> tipo de dato del objeto
     * @param object objeto a eliminar
     */
    public static <T> void delete(T object){
        getSession().delete(object);
    }
    
    /**
     * @see DAOBase.getSession()
     * @param session toma una Session ya iniciada por la funcion getSession()
     * @return devuelve una transaccion ya iniciada
     */
    public static Transaction getTransaction(Session session){
        return session.beginTransaction();
    }
   
       
}
