/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Personas;

import Resources.Fuente;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dagyus
 */
public class GuiBuscar extends JFrame implements ActionListener{
    private Container container=new Container();
    private JRadioButton rbtnDni, rbtnApellido;
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
        super("Buscar personas");
        super.setSize(700, 460);
        super.setLocationRelativeTo(null);  
        container=getContentPane();
        container.setLayout(null);
        
        rbtnDni=new JRadioButton("Buscar por DNI");
        rbtnDni.setBounds(200, 10, 150, 30);
        rbtnDni.setFont(fuente.MyFont(0, 15f));
        rbtnApellido=new JRadioButton("Buscar por Apellido");
        rbtnApellido.setBounds(360, 10, 170, 30);
        rbtnApellido.setFont(fuente.MyFont(0, 15f));
        tipoBusqueda=new ButtonGroup();
        tipoBusqueda.add(rbtnDni);
        tipoBusqueda.add(rbtnApellido);
        container.add(rbtnDni);
        container.add(rbtnApellido);
        
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

}
