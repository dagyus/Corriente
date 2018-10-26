/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Proyectos;

import Resources.Fuente;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author dagyus
 */
public class GuiBuscar extends JFrame implements ActionListener, WindowListener{
    private Container container=new Container();
    private static GuiBuscar gui=null;
    private JRadioButton rbtnNroProyecto, rbtnNombreProyecto;
    private ButtonGroup tipoBusqueda;
    private JTextField campoBusqueda;
    private Fuente fuente=new Fuente();
    private JTable resultados;
    private DefaultTableModel model;
    private String[] columnNames={"Nombre", "Dni", "hola"};
    Object[][] datos = {
        {"Juan", new Integer(25), new Boolean(false)},
        {"Sonia", new Integer(33), new Boolean(true) },
        {"Pedro", new Integer(42), new Boolean(false)},
    };
    
    public GuiBuscar(){
        super("Buscar proyectos");
        super.setSize(700, 460);
        super.setLocationRelativeTo(null);  
        container=getContentPane();
        container.setLayout(null);
        
        rbtnNroProyecto=new JRadioButton("Buscar por Nro de Proyecto");
        rbtnNroProyecto.setBounds(50, 10, 200, 30);
        rbtnNroProyecto.setFont(fuente.MyFont(0, 15f));
        rbtnNombreProyecto=new JRadioButton("Buscar por Nombre de Proyecto");
        rbtnNombreProyecto.setBounds(200, 10, 220, 30);
        rbtnNombreProyecto.setFont(fuente.MyFont(0, 15f));
        tipoBusqueda=new ButtonGroup();
        tipoBusqueda.add(rbtnNroProyecto);
        tipoBusqueda.add(rbtnNombreProyecto);
        container.add(rbtnNroProyecto);
        container.add(rbtnNombreProyecto);
        
        campoBusqueda=new JTextField();
        campoBusqueda.setBounds((super.getWidth()/2)-100, 50, 200, 30);
        container.add(campoBusqueda);
        
        model=new DefaultTableModel(datos, columnNames);
        resultados=new JTable(model);
        resultados.setBounds(50, 100, super.getWidth()-100, 300);
        JScrollPane scroll=new JScrollPane(resultados);
        scroll.setVisible(true);
        container.add(scroll);
        container.add(resultados);
        
        campoBusqueda.addActionListener(this);
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }
    
    public static GuiBuscar getInstance(){
        if(gui==null){
            gui=new GuiBuscar();
            gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        return gui;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
       
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
}
