/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.DBConnection;
import org.hibernate.Session;

/**
 *
 * @author sept
 * @param <T> cualquier tipo que reciban las funciones para manipulacion de
 * datos
 *
 */
public class DAOBase<T> {

    public DAOBase() {

    }

    /**
     * @param <T> tipo de dato del objeto
     * @param session session ya iniciada
     * @param object objeto a eliminar
     */
    public static <T> void insert(Session session, T object) {
        session.save(object);
    }

    /**
     * @param <T> tipo de dato del objeto
     * @param session session ya iniciada
     * @param object objeto a eliminar
     */
    public static <T> void update(Session session, T object) {
        session.update(object);
    }

    /**
     * @param <T> tipo de dato del objeto
     * @param session session ya iniciada
     * @param object objeto a eliminar
     */
    public static <T> void delete(Session session, T object) {
        session.delete(object);
    }

    /**
     * @see DBConnection.getSession()
     * @param <T> tipo de dato del objeto
     * @param object objeto a eliminar
     */
    public static <T> void insert(T object) {
        DBConnection.getSession().save(object);
    }

    /**
     * @see DBConnection.getSession()
     * @param <T> tipo de dato del objeto
     * @param object objeto a eliminar
     */
    public static <T> void update(T object) {
        DBConnection.getSession().update(object);
    }

    /**
     * @see DBConnection.getSession()
     * @param <T> tipo de dato del objeto
     * @param object objeto a eliminar
     */
    public static <T> void delete(T object) {
        DBConnection.getSession().delete(object);
    }

}
