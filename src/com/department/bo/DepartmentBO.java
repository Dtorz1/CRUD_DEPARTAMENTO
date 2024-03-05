/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.department.bo;

/**
 *
 * @author migue
 */
import com.department.dao.DepartmentDAO;
import com.department.db.Conexion;
import com.department.entity.Department;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Miguel
 */
public class DepartmentBO {
   
  private String mensaje="";
    private DepartmentDAO ddao= new DepartmentDAO();
   
    public String agregarDepartment(Department dpt ){
        Connection conn= Conexion.getConnection();
        try {
            mensaje = ddao.agregarDepartment(conn, dpt);
            conn.commit();
            } catch (Exception e) {
           mensaje = mensaje +" " + e.getMessage();
           
        }finally {
            try {
                if (conn != null){
                    conn.close();
            }
            } catch (Exception e) {
                mensaje = mensaje +" " + e.getMessage();
               
            }
        }
        return mensaje;
    }
   
    public String borrarDepartment( int id){
        Connection conn= Conexion.getConnection();
        try {
            mensaje = ddao.borrarDepartment(conn, id);
           //Ignora los cambios hechos desdde el principio
        } catch (Exception e) {
           mensaje = mensaje +" " + e.getMessage();
        }finally {
            try {
                if (conn != null){
                    conn.close();
            }
            } catch (Exception e) {
                mensaje = mensaje +" " + e.getMessage();
            }
        }
        return mensaje;
    }
    public String modificarDepartment(Department dpt){
        Connection conn= Conexion.getConnection(); //Me dice si la conexion esta activa
        try {
            mensaje = ddao.modificarDepartment(conn, dpt);
            conn.commit(); //Almacena los cambios en el disco duro
        } catch (Exception e) {
           mensaje = mensaje +" " + e.getMessage();
        }finally {
            try {
                if (conn != null){
                    conn.close();
            }
            } catch (Exception e) {
                mensaje = mensaje +" " + e.getMessage();
            }
        }
        return mensaje;
    }
    public void  mostrarDepartment(JTable table){
        Connection conn = Conexion.getConnection();
        ddao.mostrarDepartment(conn, table);
      try {
          conn.close();
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
    }
   public int getMaxID(){
             Connection conn = Conexion.getConnection();
        int id = ddao.getMaxID(conn);
      try {
          conn.close();
      } catch (SQLException ex) {
          System.out.println(ex.getMessage());
      }
      return id;
   }
}
