/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.department.test;

/**
 *
 * @author miguel
 */
import com.department.bo.DepartmentBO;
import com.department.entity.Department;


public class Test {
    DepartmentBO dbo = new DepartmentBO();
    Department dpt = new Department();
    String mensaje = "";
   
    public void insertar()  {
        dpt.setDepartmentId(20);
        dpt.setDepartmentName("Ingenieria");
        dpt.setManagerId(12);
        dpt.setLocationId(123);
        mensaje = dbo.agregarDepartment(dpt);
        System.out.println(mensaje);
    }
    
        
    
    public void modificar() {
        dpt.setDepartmentId(18);
        dpt.setDepartmentName("Merk");
        dpt.setManagerId(12);
        dpt.setLocationId(123);
        mensaje = dbo.modificarDepartment(dpt);
        System.out.println(mensaje);
    }
    
   
    public void eliminar() {
        mensaje = dbo.borrarDepartment(19);
        System.out.println(mensaje);
    }

 
    
    public static void main(String[] args) {
        Test test = new Test();
//        test.eliminar();
       test.modificar();  
    }
}