/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
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
    private PreparedStatement ps=null;
    
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
    public void alta(Object obj) throws SQLException, Exception{
        if(obj instanceof Proyectos){
            Proyectos p=(Proyectos) obj;
            try{
                DBConnection.conectar();
                System.out.println("aa");
                System.out.println(p.toString());
                System.out.println("\n"+Integer.parseInt(p.actividad.substring(0, 1)));
                String query="INSERT INTO proyectos(nroProyecto, "
                        + "nombreProyecto, "
                        + "direccionProyecto, "
                        + "nroDireccionProyecto, "
                        + "localidadProyecto, "
                        + "idActividadProyecto, "
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
                System.out.println("bb");
                
                ps.executeUpdate();
                DBConnection.desconectar();
            }catch(SQLException e){
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "aHubo un error al insertar el proyecto.\n"+e.getMessage());
            } catch (Exception ex) {
                //System.out.println(ex.getMessage());
                //JOptionPane.showMessageDialog(null, "bHubo un error al insertar el proyecto.\n"+ex.getMessage());
                throw new Exception(ex);
            }
        }
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

    @Override
    public void baja(Object obj) {
        
    }

    @Override
    public void modificacion(Object obj) {
        
    }
    
    

}
