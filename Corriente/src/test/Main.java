/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Model.DBConnection;
import Model.Proyectos;
import View.*;
import View.Proyectos.GuiAgregarRama;
import javax.swing.JFrame;

/**
 *
 * @author dagyus
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        DBConnection.conectar();
        DBConnection.desconectar();
        /*GuiPrincipal g=new GuiPrincipal();
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
    }
    
}
