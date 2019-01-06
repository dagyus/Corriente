/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Interfaces.IDBConnectionProperties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.metamodel.MetadataSources;

/**
 * Se encarga de la conexion a la base de datos y manejo de session y
 * transaction.
 *
 * @author dagyus
 */
public class DBConnection {

    private static SessionFactory sessionFactory;
    private static Connection conexion;
    private PreparedStatement sentencia;
    private ResultSet resultado;

    /**
     * @return session ya iniciada
     */
    public static Session getSession() {
        if (sessionFactory == null) {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // obtiene los valores de hibernate.cfg.xml
                    .build();
            sessionFactory = new MetadataSources(registry)
                    .buildMetadata().buildSessionFactory();
        }
        return sessionFactory.openSession();
    }

    /*
    *   @see DBConnection.getSession()
    *   Cierra la SessionFactory
     */
    public static void closeSession() {
        sessionFactory.close();
    }

    public static void conectar() throws Exception {
        try {
            Class.forName(IDBConnectionProperties.driver);
        } catch (ClassNotFoundException e) {
            throw new Exception("Error de driver " + e.getMessage());
        }
        try {
            String urlFinal = IDBConnectionProperties.url + IDBConnectionProperties.servidor + ":"
                    + String.valueOf(IDBConnectionProperties.puerto) + "/"
                    + IDBConnectionProperties.BD + "?autoReconnect=true&useSSL=false";
            Connection conexion = DriverManager.getConnection(urlFinal,
                    IDBConnectionProperties.usuario,
                    IDBConnectionProperties.password);
            setConexion(conexion);
        } catch (SQLException e) {
            throw new Exception("Error en la conexion \n codigo"
                    + e.getErrorCode() + "Explicacion:" + e.getMessage());
        }
    }

    public static void desconectar() throws SQLException {
        conexion.close();
    }

    public static Connection getConexion() {
        return conexion;
    }

    /**
     * @param conexion the conexion to set
     */
    public static void setConexion(Connection otherConnection) {
        conexion = otherConnection;
    }

    /**
     * @return the sentencia
     */
    public PreparedStatement getSentencia() {
        return sentencia;
    }

    /**
     * @param sentencia the sentencia to set
     */
    public void setSentencia(PreparedStatement sentencia) {
        this.sentencia = sentencia;
    }

    /**
     * @return the resultado
     */
    public ResultSet getResultado() {
        return resultado;
    }

    /**
     * @param resultado the resultado to set
     */
    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }

    /**
     * @see DBConnection.getSession()
     * @param session toma una Session ya iniciada por la funcion getSession()
     * @return devuelve una transaccion ya iniciada
     */
    public static Transaction getTransaction(Session session) {
        return session.beginTransaction();
    }
}
