/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package com.department.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author migue
 */
public class Conexion {
    private static Connection conn=null;
    private static String login="mparada";
    private static String clave="oracle1234";
    private static String url="jdbc:oracle:thin:@localhost:1521:orcl";
    
    
     
 public static Connection getConnection()  {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); //Representa nuestro Driver
            conn = DriverManager.getConnection(url,login,clave); //Prepresentacion donde la conecto, usuario donde me conecto, contraseña
            conn.setAutoCommit(false); // En cuenta los errores
            if (conn != null) {
                System.out.println("Conexion con exito");
            }else{
                System.out.println("Error de conexion");
}

 } catch (ClassNotFoundException | SQLException e) { //Excepciones que no encuentre en los parametros
            JOptionPane.showMessageDialog(null, "Conexion errronea" + e.getMessage());
        }
        return conn;
    } 
    
public void desconexion(){
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Error al desconectarse de la BD"+ e.getMessage());
        }
    }
public static void main(String[] args) {
        Conexion c = new Conexion();
        c.getConnection();
       
    }
   
}
