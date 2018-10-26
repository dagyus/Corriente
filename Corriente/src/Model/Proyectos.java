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
import javax.swing.JOptionPane;
/**
 *
 * @author dagyus
 */
public class Proyectos implements IOperacionesABM{
    
    private int nroProyecto, nroDireccion;
    private String rama, actividad, nombreUnidadProductiva, calle;

    
    
    
    

    @Override
    public void alta(Object obj) {
        
    }

    @Override
    public void baja(Object obj) {
        
    }

    @Override
    public void modificacion(Object obj) {
        
    }
    
    

}
