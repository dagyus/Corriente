/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Interfaces.IDBConnectionProperties;
import Interfaces.IOperacionesABM;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author dagyus
 */
public class Proyectos implements IOperacionesABM{
    
    private int nroProyecto, nroDireccion;
    private String actividad, nombreUnidadProductiva, calle, observaciones, localidad;
    private Date horaInicio, horaFinal;
    private SimpleDateFormat formato=new SimpleDateFormat("HH:mm");
    
    public Proyectos(int nroProyecto, int nroDireccion, 
            String actividad, String nombreUnidadProductiva, String calle, String localidad, 
            String observaciones, String horaInicio, String horaFinal) throws ParseException{
        this.nroProyecto=nroProyecto;
        this.nombreUnidadProductiva=nombreUnidadProductiva;
        this.actividad=actividad;
        this.calle=calle;
        this.nroDireccion=nroDireccion;
        this.localidad=localidad;
        this.observaciones=observaciones;
        this.horaInicio=new Date();
        this.horaInicio= formato.parse(horaInicio);
        this.horaFinal=new Date();
        this.horaFinal=formato.parse(horaFinal);
    }
    
    public Proyectos(int nroDireccion, 
            String actividad, String nombreUnidadProductiva, String calle, String localidad, 
            String observaciones, String horaInicio, String horaFinal) throws ParseException{
        this.nombreUnidadProductiva=nombreUnidadProductiva;
        this.actividad=actividad;
        this.calle=calle;
        this.nroDireccion=nroDireccion;
        this.localidad=localidad;
        this.observaciones=observaciones;
        this.horaInicio=new Date();
        this.horaInicio= formato.parse(horaInicio);
        this.horaFinal=new Date();
        this.horaFinal=formato.parse(horaFinal);
    }
    
    /**
     *
     * @param obj
     * @throws SQLException
     * 
     * Agrega un proyecto a la base de datos.
     * 
     */
    @Override
    public void alta(Object obj) throws SQLException{
        if(obj instanceof Proyectos){
            try{
                DBConnection.conectar();
                PreparedStatement ps=null;
                String query="INSERT INTO proyectos(nroProyecto,"
                        + "nombreProyecto,"
                        + "direccionProyecto,"
                        + "nroDireccionProyecto,"
                        + "localidadProyecto,"
                        + "idActividadProyecto,"
                        + "horaComienzoProyecto,"
                        + "horaFinalProyecto) VALUES (?,?,?,?,?,?,?,?);";
                ps=DBConnection.getConexion().prepareStatement(query);
                ps.setInt(1, this.nroProyecto);
                ps.setString(2, this.nombreUnidadProductiva);
                ps.setString(3, this.calle);
                ps.setInt(4, this.nroDireccion);
                ps.setInt(5, Integer.parseInt(this.localidad.substring(0, 1)));
                ps.setInt(6, Integer.parseInt(this.actividad.substring(0, 1)));
                ps.setTime(7, Time.valueOf(horaInicio.getHours()+":"+horaInicio.getMinutes()));
                ps.setTime(8, Time.valueOf(horaFinal.getHours()+":"+horaFinal.getMinutes()));
                ps.executeUpdate();
                DBConnection.desconectar();
                
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Hubo un error al crear el proyecto.");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Hubo un error al crear el proyecto.");
            }
        }
    }

    @Override
    public void baja(Object obj) {
        
    }

    @Override
    public void modificacion(Object obj) {
        
    }
    
    

}
