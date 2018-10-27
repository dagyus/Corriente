/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Proyectos;



import Model.DBConnection;
import javax.swing.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JSpinner.DateEditor;

/**
 *
 * @author dagyus
 */
public class GuiAgregarProyecto extends JFrame implements WindowListener, ItemListener, ActionListener{    
    private static GuiAgregarProyecto gui=null;
    private Container container=new Container(); 
    private JTextField tNombreProyecto, tDireccion, tNroDireccion, tMunicipio, tNroProyecto;
    private JComboBox cActividad, cMunicipio;
    private JTextArea observaciones;
    private JLabel hasta;
    private List<JLabel> labels;
    private Date date = new Date();
    private SpinnerDateModel smComienzo = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
    private SpinnerDateModel smSalida = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
    private JSpinner horarioComienzo = new JSpinner(smComienzo);
    private JSpinner horarioSalida = new JSpinner(smSalida);
    private DateEditor deComienzo = new DateEditor(horarioComienzo, "HH:mm");
    private DateEditor deSalida = new DateEditor(horarioSalida, "HH:mm");
    private JButton btnAgregar;
    private String sqlQuery;
    private PreparedStatement ps;
    private ResultSet rs;
    private Integer iActividad;
    private String nActividad;
    
    public GuiAgregarProyecto() throws SQLException, Exception{
        super("Agregar proyecto");
        int x=20, y=5;
        labels=new ArrayList();
        container=super.getContentPane();
        container.setLayout(null);
        super.setSize(500, 350);
        super.setLocationRelativeTo(null);
        for(int i=0;i<8;i++){
            labels.add(new JLabel());
        }
        for(JLabel l: labels){
            l.setBounds(x, y, 180, 30);
            y+=25;
        }
        labels.get(0).setText("Numero de Proyecto: ");
        labels.get(1).setText("Nombre de Unidad Productiva: ");
        labels.get(2).setText("Actividad: ");
        labels.get(3).setText("Horario de Trabajo: ");
        labels.get(4).setText("Direccion: ");
        labels.get(5).setText("Numero de Direccion: ");
        labels.get(6).setText("Municipio: ");
        labels.get(7).setText("Observaciones: ");
        for(JLabel l: labels){
            container.add(l);
        }
        x=220;
        y=7;
        tNroProyecto=new JTextField();
        tNroProyecto.setBounds(x, y, 150, 25);
        container.add(tNroProyecto);
        
        tNombreProyecto=new JTextField();
        tNombreProyecto.setBounds(x, y+=25, 150, 25);
        container.add(tNombreProyecto);
        
        cActividad=new JComboBox();
        cActividad.setBounds(x, y+=25, 150, 25);
        DBConnection.conectar();
        sqlQuery="SELECT * FROM actividadproyecto;";
        ps=DBConnection.getConexion().prepareStatement(sqlQuery);
        rs=ps.executeQuery();
        while(rs.next()){
            nActividad=rs.getString("nombreActividadProyecto");
            iActividad=rs.getInt("idActividadProyecto");
            cActividad.addItem(iActividad+"-"+nActividad);
        }
        DBConnection.desconectar();
        container.add(cActividad);
        
        horarioComienzo.setEditor(deComienzo);
        horarioComienzo.setBounds(x, y+=25, 55, 25);
        container.add(horarioComienzo);
        JOptionPane.showMessageDialog(null,String.valueOf(horarioComienzo.getValue()).substring(11, 16));
        
        hasta=new JLabel("hasta");
        hasta.setBounds(x+57, y, 35, 25);
        container.add(hasta);
        
        horarioSalida.setEditor(deSalida);
        horarioSalida.setBounds(x+94, y, 55, 25);
        container.add(horarioSalida);   
                
        tDireccion=new JTextField();
        tDireccion.setBounds(x, y+=25, 150, 25);
        container.add(tDireccion);
        
        tNroDireccion=new JTextField();
        tNroDireccion.setBounds(x, y+=25, 150, 25);
        container.add(tNroDireccion);
        
        cMunicipio=new JComboBox();
        cMunicipio.setBounds(x, y+=25, 150, 25);
        cMunicipio.addItem("hola");    //agregar items (crear funcion para cargar desde base de datos)
        container.add(cMunicipio);
        
        observaciones=new JTextArea(3, 20);
        JScrollPane scroll=new JScrollPane(observaciones);
        scroll.setViewportView(observaciones);
        observaciones.setBounds(x, y+=25, 150, 60);
        container.add(observaciones);
        super.add(scroll);
        
        
        super.setVisible(true);
        super.addWindowListener(this);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static GuiAgregarProyecto getInstance() throws Exception {
        if(gui==null){
            gui=new GuiAgregarProyecto();
            gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        return gui;
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
        if(e.getSource()==gui){
            gui.dispose();
            gui=null;
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
}
