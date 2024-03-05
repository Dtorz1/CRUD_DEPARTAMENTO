/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.department.dao;

/**
 *
 * @author migue
 */

    


import com.department.entity.Department;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aleja
 */
public class DepartmentDAO {
   
        private String mensaje = "";
   
    public String agregarDepartment(Connection con, Department dpt) { // Llamo la clase department de entity
        PreparedStatement pst=null; //Prepared pst es el nombre
        String sql= "INSERT INTO DEPARTMENTS (DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER_ID,LOCATION_ID)"+" VALUES(?,?,?,?)";
        try{
            pst = con.prepareStatement(sql); //Verificar lo que vamos a poner en la conexion
            pst.setInt(1, dpt.getDepartmentId());
            pst.setString(2, dpt.getDepartmentName());
            pst.setInt(3, dpt.getManagerId());
            pst.setInt(4 , dpt.getLocationId());
            mensaje = "Guardado Correctamente";
            pst.execute();
            pst.close();
        } catch (SQLException e){
            mensaje ="No se puede guardar \n" + e.getMessage() + " " + sql;
       
        }
        return mensaje;
    }
    public String borrarDepartment(Connection con, int id){
          PreparedStatement pst=null;
        String sql="DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1,id);
            mensaje="Eliminado Correctamente" + " " + sql;
            pst.execute();
            pst.close();
           
        } catch (SQLException e) {
           
             mensaje="No se pudo eliminar \n "+ e.getMessage() + " " + sql;
        }
        return mensaje;
    }
   
   
    public String modificarDepartment(Connection con, Department dpt){
          PreparedStatement pst=null;
        String sql="update departments set department_name = ?,manager_id = ? ,location_id = ?"+
                "where department_id= ?";
        try {
            pst = con.prepareStatement(sql); //Verificar lo que vamos a poner en la conexion
            pst.setString(1, dpt.getDepartmentName());
            pst.setInt(2, dpt.getManagerId());
            pst.setInt(3, dpt.getLocationId());
            pst.setInt(4, dpt.getDepartmentId());
            mensaje="Modificado Correctamente";
            pst.execute();
            pst.close();
           
        } catch (SQLException e) {
           
             mensaje="No se pudo modificar \n "+ e.getMessage();
        }
        return mensaje;
    }
    public void  mostrarDepartment(Connection con, JTable table)
    {                                                          // Recibir conexiones el nombre de la table
        DefaultTableModel model; //Llamar el objeto de nuestra tabla
        String [] col = {"ID", "Nombre Dept", "ManagerID","LugarID"}; // Agregamos los parametros a nuestra columna
        model = new DefaultTableModel(null, col); // Se lo agregamos a nuestra tabla
       
        String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID"; //Orden numerico, Creamos select que sera consulta
        String [] filas = new String[4]; // # De datos que ingreso Nuestras filas
        Statement st = null; // Ejecutar nuestro Query  
        ResultSet rs = null;
       
       
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql); // Tener resultados de ese sql, que va a hacer a nuestro statement
            while (rs.next()) {                
                for (int i = 0; i < 4; i++) {
                    filas[i] = rs.getString(i +1);
                }
                model.addRow(filas); // Guardar directamente las filas
            }
            table.setModel(model); // Guardar datos en el modelo de la tabla que estoy recibiendo
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error para listar la tabla");
        }
    }
    
    public int getMaxID(Connection con){
        int id=0;
        PreparedStatement pst = null;
        ResultSet rs= null;
        String sql = "SELECT MAX(DEPARTMENT_ID)+1 as id FROM DEPARTMENTS";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()) {
                id= rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar id"+ e.getMessage());
        }
        return id;
        
    }
}
    

