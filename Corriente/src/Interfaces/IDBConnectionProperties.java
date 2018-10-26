/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author dagyus
 */
public interface IDBConnectionProperties {
    final String driver = "com.mysql.jdbc.Driver";
    final String servidor = "localhost";
    final String usuario = "root";
    final String password = "admin";
    final String BD = "corriente";
    final String url = "jdbc:mysql://";
    final String options = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
    final int puerto = 3306;
}
