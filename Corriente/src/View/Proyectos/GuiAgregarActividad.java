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
import java.sql.ResultSet;
import javax.swing.*;


public class GuiAgregarActividad extends JFrame implements ActionListener{
    private Container container=new Container();
    private JLabel lNombre, lRama;
    private JComboBox cRama;
    private JTextField tfNombre;
    private JButton btnAgregar;
    private ResultSet rs;
    private String sqlQuery;
    private PreparedStatement ps= null;
    
    public GuiAgregarActividad() throws Exception{
        super("Agregar Actividad");
        int x=20, y=5;
        container=super.getContentPane();
        container.setLayout(null);
        super.setSize(400, 200);
        super.setLocationRelativeTo(null);
        lRama=new JLabel("Rama: ");
        lRama.setBounds(10, 20, 110, 30);
        container.add(lRama);
        cRama=new JComboBox();
        DBConnection.conectar();
        sqlQuery="SELECT * FROM ramaproyecto;";
        ps=DBConnection.getConexion().prepareStatement(sqlQuery);
        rs=ps.executeQuery();
        while(rs.next()){
            String nRama=rs.getString("nombreRamaProyecto");
            Integer iRama=rs.getInt("idRamaProyecto");
            cRama.addItem(iRama+"-"+nRama);
        }
        DBConnection.desconectar();
        cRama.setBounds(130, 20, 250, 30);
        container.add(cRama);
        lNombre=new JLabel("Nombre actividad:");
        lNombre.setBounds(10, 70, 110, 30);
        container.add(lNombre);
        tfNombre=new JTextField();
        tfNombre.setBounds(130, 70, 250, 30);
        container.add(tfNombre);
        btnAgregar=new JButton("Agregar Actividad");
        btnAgregar.setBounds(130, 110, 140, 40);
        container.add(btnAgregar);
        btnAgregar.addActionListener(this);
        super.setVisible(true);
        super.setResizable(false);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==btnAgregar){
            String nombreActividad=tfNombre.getText();
            if("".equals(nombreActividad)){
                JOptionPane.showMessageDialog(null, "Ingrese nombre de actividad.");
            }else{
                try {
                    DBConnection.conectar();
                    String sql;
                    sql="INSERT INTO actividadproyecto (nombreActividadProyecto, idRamaProyecto) VALUES (?,?);";
                    ps=DBConnection.getConexion().prepareStatement(sql);
                    ps.setString(1, nombreActividad);
                    String nRama=cRama.getSelectedItem().toString();
                    ps.setInt(2, Integer.parseInt(nRama.substring(0, 1)));
                    ps.executeUpdate();
                    DBConnection.desconectar();
                    
                } catch (Exception ex) {
                }
            }
        }
    }
}
