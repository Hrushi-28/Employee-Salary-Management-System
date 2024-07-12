package com.project.empapp;

public interface EmployeeDaoIntrf {

    //create employee
    public void createEmployee(Employee emp);
    //show employee
    public  void showAllEmployee();
    //show employee based on ID
    public void showEmployeeBasedOnID(int id);
    //update employee
    public void updateEmployee(int id,String name);
    //delete employee
    public void deleteEmployee(int id);
}
