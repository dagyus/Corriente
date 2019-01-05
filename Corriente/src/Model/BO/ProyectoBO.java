/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.BO;
import Interfaces.IOperacionesABM;
import Model.DBConnection;
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
public class ProyectoBO implements IOperacionesABM{
    
    private int nroProyecto, nroDireccion;
    private String actividad, nombreUnidadProductiva, calle, observaciones, localidad;
    private Date horaInicio, horaFinal;
    private SimpleDateFormat formato=new SimpleDateFormat("HH:mm");
    private PreparedStatement ps=null;
    
    public ProyectoBO(int nroProyecto, int nroDireccion, 
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
    
    public ProyectoBO(int nroDireccion, 
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
    public void alta(Object obj) throws SQLException, Exception{
        if(obj instanceof ProyectoBO){
            ProyectoBO p=(ProyectoBO) obj;
            try{
                DBConnection.conectar();
                String query="INSERT INTO proyectos(nroProyecto, "
                        + "nombreProyecto, "
                        + "direccionProyecto, "
                        + "nroDireccionProyecto, "
                        + "localidadProyecto, "
                        + "idActividad, "
                        + "horaComienzoProyecto, "
                        + "horaFinalProyecto) VALUES (?,?,?,?,?,?,?,?);";
                ps=DBConnection.getConexion().prepareStatement(query);
                ps.setInt(1, p.nroProyecto);
                ps.setString(2, p.nombreUnidadProductiva);
                ps.setString(3, p.calle);
                ps.setString(4, String.valueOf(p.nroDireccion));
                ps.setString(5, p.localidad);
                ps.setInt(6, Integer.parseInt(p.actividad.substring(0, 1)));
                ps.setString(7, (String.valueOf(p.horaInicio.getHours())+":"+String.valueOf(p.horaInicio.getMinutes())));
                ps.setString(8, (String.valueOf(p.horaFinal.getHours())+":"+String.valueOf(p.horaFinal.getMinutes())));           
                ps.executeUpdate();
                DBConnection.desconectar();
            }catch(SQLException e){
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "aHubo un error al insertar el proyecto.\n"+e.getMessage());
            }
        }
    }

    public int getNroProyecto() {
        return nroProyecto;
    }

    public void setNroProyecto(int nroProyecto) {
        this.nroProyecto = nroProyecto;
    }

    public int getNroDireccion() {
        return nroDireccion;
    }

    public void setNroDireccion(int nroDireccion) {
        this.nroDireccion = nroDireccion;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getNombreUnidadProductiva() {
        return nombreUnidadProductiva;
    }

    public void setNombreUnidadProductiva(String nombreUnidadProductiva) {
        this.nombreUnidadProductiva = nombreUnidadProductiva;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }
    
    @Override
    public String toString(){
        return (nroProyecto+" "+
                nombreUnidadProductiva+" "+
                calle+" "+
                nroDireccion+" "+
                localidad+" "+
                actividad+" "+
                horaInicio+" "+
                horaFinal);
    }
    
    public static ProyectoBO getProyectoByNroProyecto(int nroProyecto) throws SQLException, Exception{
        DBConnection.conectar();
        String sqlQuery="SELECT * FROM proyectos where nroProyecto=?;";
        PreparedStatement ps=DBConnection.getConexion().prepareStatement(sqlQuery);
        ps.setInt(0, nroProyecto);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            /*
            
            
            
            
            
            */
        }
        DBConnection.desconectar();
        return null;
    }

    @Override
    public void baja(Object obj) {
        
    }

    @Override
    public void modificacion(Object obj) throws SQLException, Exception{
        if(obj instanceof ProyectoBO){
            ProyectoBO p=(ProyectoBO) obj;
            try{
                DBConnection.conectar();
                String query="INSERT INTO proyectos(nroProyecto, "
                        + "nombreProyecto, "
                        + "direccionProyecto, "
                        + "nroDireccionProyecto, "
                        + "localidadProyecto, "
                        + "idActividad, "
                        + "horaComienzoProyecto, "
                        + "horaFinalProyecto) VALUES (?,?,?,?,?,?,?,?);";
                ps=DBConnection.getConexion().prepareStatement(query);
                ps.setInt(1, p.nroProyecto);
                ps.setString(2, p.nombreUnidadProductiva);
                ps.setString(3, p.calle);
                ps.setString(4, String.valueOf(p.nroDireccion));
                ps.setString(5, p.localidad);
                ps.setInt(6, Integer.parseInt(p.actividad.substring(0, 1)));
                ps.setString(7, (String.valueOf(p.horaInicio.getHours())+":"+String.valueOf(p.horaInicio.getMinutes())));
                ps.setString(8, (String.valueOf(p.horaFinal.getHours())+":"+String.valueOf(p.horaFinal.getMinutes())));           
                ps.executeUpdate();
                DBConnection.desconectar();
            }catch(SQLException e){
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "aHubo un error al insertar el proyecto.\n"+e.getMessage());
            }
        }
    }
    
    

}
