/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Proyectos;

import Model.DBConnection;
import Model.BO.ProyectoBO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author sept
 */
public class GuiModificarProyecto extends JFrame implements ActionListener, WindowListener{
    private Container container=new Container();
    private JLabel lblProyecto;
    private JComboBox cmbSeleccionarProyecto;
    private JButton btnModificar;
    private static GuiModificarProyecto gui;
    
    GuiModificarProyecto() throws Exception, SQLException{
        super("Modificar Proyecto");
        container=super.getContentPane();
        container.setLayout(null);
        super.setSize(360, 130);
        super.setLocationRelativeTo(null);
        
        lblProyecto=new JLabel("Seleccionar Proyecto: ");
        lblProyecto.setBounds(10, 10, 130, 30);
        container.add(lblProyecto);
        
        cmbSeleccionarProyecto=new JComboBox();
        DBConnection.conectar();
        String sqlQuery="SELECT nroProyecto, nombreProyecto FROM proyectos;";
        PreparedStatement ps=DBConnection.getConexion().prepareStatement(sqlQuery);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            String nProyecto=rs.getString("nombreProyecto");
            Integer iProyecto=rs.getInt("nroProyecto");
            cmbSeleccionarProyecto.addItem(iProyecto+"-"+nProyecto);
        }
        DBConnection.desconectar();
        cmbSeleccionarProyecto.setBounds(150, 10, 200, 30);
        container.add(cmbSeleccionarProyecto);
        
        btnModificar=new JButton("Modificar Proyecto");
        btnModificar.setBounds(100, 50, 150, 40);
        container.add(btnModificar);
        
        btnModificar.addActionListener(this);
        super.setResizable(false);
        super.setVisible(true);
        super.addWindowListener(this);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public static GuiModificarProyecto getInstance() throws Exception{
        if(gui==null){
            gui=new GuiModificarProyecto();
            gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        return gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnModificar){
            try {
                String cProyecto=String.valueOf(cmbSeleccionarProyecto);
                int nroProyecto=Integer.parseInt(cProyecto.substring(0, 4));
                GuiAgregarProyecto guiAgregar=new GuiAgregarProyecto(ProyectoBO.getProyectoByNroProyecto(nroProyecto));
            } catch (Exception ex) {
                Logger.getLogger(GuiModificarProyecto.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        if(e.getSource()==gui){
            gui.dispose();
            gui=null;
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        
    }
}
