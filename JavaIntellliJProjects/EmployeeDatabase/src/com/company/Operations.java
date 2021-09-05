package com.company;

import java.util.Collections;
import java.util.Vector;
import java.util.Comparator;

public class Operations {
    Vector<Employee> employees;

    public Operations() {
        employees = new Vector<Employee>();
    }

    void printInformation() {
        for (int i = 0; i < this.employees.size(); i++) {
            System.out.println("---------------------------------------");
            System.out.println("Employee "+ (i+1) +". \n"+
                    "ID -> "+ this.employees.get(i).getID() +
                    "\nName -> "+ this.employees.get(i).getName() +
                    "\nSex -> "+ this.employees.get(i).getGender() +
                    "\nJobTitle -> "+
                    this.employees.get(i).getJobTitle() +
                    "\nOrganization -> "+
                    this.employees.get(i).getOrganization() +
                    "\nSalary -> "+
                    this.employees.get(i).getSalary());
            System.out.println("---------------------------------------");
        }
    }

    boolean addEmployee(Employee employee) {
        if (findEmployeeName(employee.getName()) >= 0)
            return false;
        employees.add(employee);
        return true;
    }

    boolean removeEmployee(String name) {
        int foundEmployee = findEmployeeName(name);
        if (foundEmployee < 0) {
            System.out.println("---------------------------------------");
            System.out.println(name +
                    ", was not found in the vector");
            System.out.println("---------------------------------------");
            return false;
        }
        this.employees.remove(foundEmployee);
        System.out.println("---------------------------------------");
        System.out.println(name +
                ", was successfully deleted");
        System.out.println("---------------------------------------");
        return false;
    }

    void compareEmployeeSalary(String emp1Name, String emp2Name) {
        int position1 = findEmployeeName(emp1Name);
        int position2 = findEmployeeName(emp2Name);
        System.out.println("---------------------------------------");
        if (this.employees.get(position1).getSalary() >
            this.employees.get(position2).getSalary())
            System.out.println(this.employees.get(position1).getName()
                    +" earns "+
                    (this.employees.get(position1).getSalary() -
                            this.employees.get(position2).getSalary())+
                    " more than "+
                    this.employees.get(position2).getName());
        else if (this.employees.get(position1).getSalary() ==
                this.employees.get(position2).getSalary())
            System.out.println(this.employees.get(position1).getName()+
                    " and "+
                    this.employees.get(position2).getName()
                    +" earn the same amount of money");
        else
            System.out.println(this.employees.get(position2).getName()
                    +" earns "+
                    (this.employees.get(position2).getSalary() -
                            this.employees.get(position1).getSalary())+
                    " more than "+
                    this.employees.get(position1).getName());
        System.out.println("---------------------------------------");
    }

    Employee specificEmployeeName(String name) {
        int position = findEmployeeName(name);
        if (position >= 0)
            return this.employees.get(position);
        return null;
    }

    Employee specificEmployeeID(String id) {
        int position = findEmployeeID(id);
        if (position >= 0)
            return this.employees.get(position);
        return null;
    }

    void sortOnName() {
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
            }
        });
        System.out.println("The vector has been sorted");
    }

    private int findEmployeeName(String EmployeeName) {
        for (int i = 0; i < this.employees.size(); i++) {
            Employee employee = this.employees.get(i);
            if (employee.getName().equals(EmployeeName))
                return i;
        }
        return -1;
    }

    private int findEmployeeID(String EmployeeID) {
        for (int i = 0; i < this.employees.size(); i++) {
            Employee employee = this.employees.get(i);
            if (employee.getID().equals(EmployeeID))
                return i;
        }
        return -1;
    }
}