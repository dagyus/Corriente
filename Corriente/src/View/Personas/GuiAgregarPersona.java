package View.Personas;

import java.awt.Container;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.toedter.calendar.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dagyus
 */
public class GuiAgregarPersona extends JFrame implements WindowListener, FocusListener{
    private static final int ID_INICIO=1;
    private static final long serialVersionUID = 1L;
    private static GuiAgregarPersona gui=null;
    private Container container=new Container();
    private JTextField nombre, apellido, dni, cuil, direccion, telefono, nroProyecto, nombreProyecto;
    private JRadioButton masculino, femenino;
    private JRadioButton hacemosFuturo, salarioSocialComplementario;
    private ButtonGroup beneficio, genero;
    private List<JLabel> labels;
    private JDateChooser calendario;
    private JFileChooser buscador=new JFileChooser();
    private BufferedImage img=null;
    private FileNameExtensionFilter filtro=new FileNameExtensionFilter("Archivo de imagen", "jpg", "png", "bmp", "jpeg");
    private JButton cargarDatos, resetear, dniPrimera, dniSegunda, cuilImagen;
    private JLabel lDniPrimera, lDniSegunda, lCuilImagen;
    
    public GuiAgregarPersona(){
        super("Agregar");
        setSize(380,450);
        super.setLocationRelativeTo(null);
        container=getContentPane();
        container.setLayout(null);
        int x=20, y=10;
        labels=new ArrayList();
        for(int i=0;i<=14;i++){
            labels.add(new JLabel());
        }
        for(JLabel l: labels){
            l.setBounds(x, y, 150, 30);
            y+=25;
        }
        labels.get(0).setText("Nombre: ");
        labels.get(1).setText("Apellido: ");
        labels.get(2).setText("DNI: ");
        labels.get(3).setText("Cuil: ");
        labels.get(4).setText("Fecha de Nacimiento: ");
        labels.get(5).setText("Genero: ");
        labels.get(6).setText("Direccion: ");
        labels.get(7).setText("Telefono: ");
        labels.get(8).setText("Programa: ");
        labels.get(9).setText("Numero de proyecto: ");
        labels.get(10).setText("Nombre de proyecto: ");
        labels.get(11).setText("DNI (primera pagina): ");
        labels.get(12).setText("DNI (segunda pagina): ");
        labels.get(13).setText("CUIL (imagen): ");
        for(JLabel l: labels){
            container.add(l);
        }
        x=150;
        y=12;
        nombre= new JTextField();
        nombre.setBounds(x, y, 200, 25);
        container.add(nombre);
        apellido=new JTextField();
        apellido.setBounds(x, y+=25, 200, 25);
        container.add(apellido);
        dni=new JTextField();
        dni.setBounds(x, y+=25, 200, 25);
        container.add(dni);
        cuil=new JTextField();
        cuil.setBounds(x, y+=25, 200, 25);
        container.add(cuil);
        calendario=new JDateChooser();
        calendario.setBounds(x, y+=25, 200, 25);
        container.add(calendario);
        masculino=new JRadioButton("Masculino");
        masculino.setBounds(x, y+=25, 100, 25);
        femenino=new JRadioButton("Femenino");
        femenino.setBounds(x+100, y, 100, 25);
        genero=new ButtonGroup();
        genero.add(masculino);
        genero.add(femenino);
        container.add(masculino);
        container.add(femenino);
        direccion=new JTextField();
        direccion.setBounds(x, y+=25, 200, 25);
        container.add(direccion);
        telefono=new JTextField();
        telefono.setBounds(x, y+=25, 200, 25);
        container.add(telefono);
        hacemosFuturo=new JRadioButton("HF");
        hacemosFuturo.setBounds(x, y+=25, 100, 25);
        salarioSocialComplementario=new JRadioButton("SSC");
        salarioSocialComplementario.setBounds(x+100, y, 100, 25);
        beneficio=new ButtonGroup();
        beneficio.add(hacemosFuturo);
        beneficio.add(salarioSocialComplementario);
        container.add(hacemosFuturo);
        container.add(salarioSocialComplementario);
        nroProyecto=new JTextField();
        nroProyecto.setBounds(x, y+=25, 200, 25);
        container.add(nroProyecto);
        nombreProyecto=new JTextField();
        nombreProyecto.setBounds(x, y+=25, 200, 25);
        container.add(nombreProyecto);
        lDniPrimera=new JLabel("");
        lDniPrimera.setBounds(x, y+=25, 125, 25);
        container.add(lDniPrimera);
        dniPrimera=new JButton("Buscar");
        dniPrimera.setBounds(x+125, y, 75, 25);
        container.add(dniPrimera);
        lDniSegunda=new JLabel("");
        lDniSegunda.setBounds(x, y+=25, 125, 25);
        container.add(lDniSegunda);
        dniSegunda=new JButton("Buscar");
        dniSegunda.setBounds(x+125, y, 75, 25);
        container.add(dniSegunda);
        lCuilImagen=new JLabel("");
        lCuilImagen.setBounds(x, y+=25, 125, 25);
        container.add(lCuilImagen);
        cuilImagen=new JButton("Buscar");
        cuilImagen.setBounds(x+125, y, 75, 25);
        container.add(cuilImagen);
        cargarDatos=new JButton("Cargar Datos");
        cargarDatos.setBounds(50, 370, 120, 30);
        container.add(cargarDatos);
        resetear=new JButton("Resetear");
        resetear.setBounds(180, 370, 100, 30);
        container.add(resetear);
        super.addWindowListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    public static GuiAgregarPersona getInstance(){
        if(gui==null){
            gui=new GuiAgregarPersona();
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

    @Override
    public void focusGained(FocusEvent e) {
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        
    }
    
}
