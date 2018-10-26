/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author dagyus
 */
public class GuiLogin extends JFrame{
    private JTextField usuario, password;
    private JLabel lUsuario, lPassword, lRol;
    private JButton btnLogin;
    private JComboBox roles;
    private Container container=new Container();
    
    public GuiLogin(){
        super("Login");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        super.setBounds((screenSize.width/2)-175, (screenSize.height/2)-100, 350, 200);
        container=getContentPane();
        container.setLayout(null);
        lUsuario=new JLabel("Usuario: ");
        lUsuario.setBounds(40, 10, 60, 30);
        container.add(lUsuario);
        lPassword=new JLabel("Contraseña: ");
        lPassword.setBounds(40, 45, 80, 30);
        container.add(lPassword);
        lRol=new JLabel("Rol: ");
        lRol.setBounds(40, 80, 80, 30);
        container.add(lRol);
        usuario=new JTextField();
        usuario.setBounds(140, 12, 150, 30);
        container.add(usuario);
        password=new JTextField();
        password.setBounds(140, 47, 150, 30);
        container.add(password);
        roles=new JComboBox();
        roles.setBounds(140, 82, 150, 30);
        roles.addItem("Administrador");
        roles.addItem("Usuario");
        container.add(roles);
        btnLogin=new JButton("Iniciar Sesion");
        btnLogin.setBounds(90, 120, 150, 30);
        container.add(btnLogin);
        setVisible(true);
    }
}
