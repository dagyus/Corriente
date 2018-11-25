/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.sql.SQLException;

/**
 *
 * @author dagyus
 */
public interface IOperacionesABM {
    public abstract void alta(Object obj) throws SQLException, Exception;
    public abstract void baja(Object obj) throws SQLException, Exception;
    public abstract void modificacion(Object obj) throws SQLException, Exception;
}
