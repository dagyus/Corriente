/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Proyectos;

import Model.DBConnection;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class GuiAgregarRama extends JFrame implements ActionListener{
    private Container container=new Container();
    private JLabel lNombre;
    private JTextField tfNombre;
    private JButton btnAgregar;
    
    public GuiAgregarRama() throws Exception{
        super("Agregar proyecto");
        int x=20, y=5;
        container=super.getContentPane();
        container.setLayout(null);
        super.setSize(400, 200);
        super.setLocationRelativeTo(null);
        lNombre=new JLabel("Nombre rama:");
        lNombre.setBounds(20, 30, 90, 30);
        container.add(lNombre);
        tfNombre=new JTextField();
        tfNombre.setBounds(120, 30, 250, 30);
        container.add(tfNombre);
        btnAgregar=new JButton("Agregar Rama");
        btnAgregar.setBounds(130, 90, 140, 40);
        container.add(btnAgregar);
        btnAgregar.addActionListener(this);
        super.setVisible(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==btnAgregar){
            String nombreRama=tfNombre.getText();
            if(nombreRama==""){
                JOptionPane.showMessageDialog(null, "Ingrese nombre de rama.");
            }else{
                try {
                    DBConnection.conectar();
                    String sqlQuery;
                    PreparedStatement ps= null;
                    sqlQuery="INSERT INTO ramaproyecto (nombreRamaProyecto) VALUES (?);";
                    ps=DBConnection.getConexion().prepareStatement(sqlQuery);
                    ps.setString(1, nombreRama);
                    ps.executeUpdate();
                    DBConnection.desconectar();
                    
                } catch (Exception ex) {
                    Logger.getLogger(GuiAgregarRama.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
