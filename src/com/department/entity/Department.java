/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.department.entity;

/**
 *
 * @author migue
 */
public class Department {
    
    private int departmentId;
    private String departmentName;
    private int managerId;
    private int locationId;
    
    public Department() {}

    public Department(int departmentId, String departmentName, int managerId, int locationId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.managerId = managerId;
        this.locationId = locationId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getManagerId() {
        return managerId;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return "Department{" + "departmentId=" + departmentId + ", departmentName=" + departmentName + ", managerId=" + managerId + ", locationId=" + locationId + '}';
    }
    
       
    
}
