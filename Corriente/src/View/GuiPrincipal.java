/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import View.Personas.*;
import Resources.*;
import View.Proyectos.*;
import com.toedter.calendar.*;
import javax.swing.*;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author dagyus
 */
public class GuiPrincipal extends JFrame implements ActionListener{
    private Container container=new Container();
    final private Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
    final private JCalendar calendario;
    final private JButton btnBuscar, btnAgregar, btnEditar;
    final private ImageIcon iconFind, iconAdd, iconUpdate;
    final private Fuente font=new Fuente();
    final private JMenuBar menu;
    final private JMenu base, proyectos;
    final private JMenuItem agregar, buscar, quitar, agregarProyecto, quitarProyecto, modificarProyecto, buscarProyecto;
    
    public GuiPrincipal(){
        super("CCC");
        super.setResizable(false);
        super.setBounds((screenSize.width/2)-400, (screenSize.height/2)-230, 800, 460);
        container=super.getContentPane();
        container.setLayout(null);
        menu=new JMenuBar();
        base=new JMenu("Base");
        agregar=new JMenuItem("Agregar");
        buscar=new JMenuItem("Buscar");
        quitar=new JMenuItem("Quitar");
        base.add(agregar);
        base.add(buscar);
        base.add(quitar);
        menu.add(base);
        proyectos=new JMenu("Proyectos");
        agregarProyecto=new JMenuItem("Agregar Proyecto");
        buscarProyecto=new JMenuItem("Buscar Proyecto");
        quitarProyecto=new JMenuItem("Quitar Proyecto");
        modificarProyecto=new JMenuItem("Modificar Proyecto");
        proyectos.add(buscarProyecto);
        proyectos.add(agregarProyecto);
        proyectos.add(modificarProyecto);
        proyectos.add(quitarProyecto);
        menu.add(proyectos);
        menu.setBounds(0, 0, super.getWidth(), 20);
        menu.setFont(font.MyFont(0, 20f));
        container.add(menu);
        btnBuscar=new JButton("Buscar");
        btnBuscar.setBounds(0, 20, 250, 200);
        iconFind=new ImageIcon("src/images/find.png");
        btnBuscar.setIconTextGap(10);
        btnBuscar.setIcon(iconFind);
        btnBuscar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBuscar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBuscar.setFont(font.MyFont(0, 27f));
        container.add(btnBuscar);
        btnAgregar=new JButton("Agregar");
        btnAgregar.setBounds(0, 220, 250, 200);
        btnAgregar.setIconTextGap(10);
        iconAdd=new ImageIcon("src/images/add.png");
        btnAgregar.setIcon(iconAdd);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregar.setFont(font.MyFont(0, 27f));
        container.add(btnAgregar);
        calendario=new JCalendar();
        calendario.setBounds(250, 20, 250, 200);
        calendario.setTodayButtonText("Dia actual");
        calendario.setTodayButtonVisible(true);
        container.add(calendario);
        btnEditar=new JButton("Editar");
        btnEditar.setBounds(250, 220, 250, 200);
        btnEditar.setIconTextGap(10);
        iconUpdate=new ImageIcon("src/images/update.png");
        btnEditar.setIcon(iconUpdate);
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.setFont(font.MyFont(0, 27f));
        container.add(btnEditar);
        buscarProyecto.addActionListener(this);
        agregarProyecto.addActionListener(this);
        modificarProyecto.addActionListener(this);
        btnBuscar.addActionListener(this);
        btnAgregar.addActionListener(this);
        btnEditar.addActionListener(this);
        super.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnBuscar){
            View.Personas.GuiBuscar guiBuscar=new View.Personas.GuiBuscar();
        }
        if(e.getSource()==btnAgregar){
            GuiAgregarPersona.getInstance();
        }
        if(e.getSource()==btnEditar){
            JOptionPane.showMessageDialog(null, "Boton de editar apretado");
        }
        if(e.getSource()==buscarProyecto){
            View.Proyectos.GuiBuscar.getInstance();
        }
        if(e.getSource()==agregarProyecto){
            try {
                GuiAgregarProyecto.getInstance();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if(e.getSource()==modificarProyecto){
            try{
                GuiModificarProyecto.getInstance();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "No se puede abrir la ventana."+ ex.getMessage());
            }
        }
    }

}
