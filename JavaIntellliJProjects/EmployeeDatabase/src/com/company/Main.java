package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Operations op = new Operations();
    private static Employee e = new Employee();

    public static void main(String[] args) {
        boolean exit = false;
        int choice;
        while (!exit) {
            printActionMenu();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    op.printInformation();
                    break;
                case 2:
                    inputEmployeesDetails();
                    break;
                case 3:
                    deleteEmployeeDetails();
                    break;
                case 4:
                    compareEmployees();
                    break;
                case 5:
                    searchSpecificEmployee();
                    break;
                case 6:
                    op.sortOnName();
                    break;
                case 7:
                    getCountOfInstances();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    public static void inputEmployeesDetails() {
        e.opCount(1);
        System.out.print("Enter the name: ");
        String name = sc.nextLine();
        System.out.print("Enter the id: ");
        String id = sc.nextLine();
        System.out.print("Enter the gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter the job title: ");
        String job = sc.nextLine();
        System.out.print("Enter the organization "+
                "the employee works for: ");
        String organization = sc.nextLine();
        System.out.print("Enter the salary: ");
        double salary = sc.nextDouble();
        Employee employee = Employee.createEmployee(name,
                id, gender, job, organization, salary);
        System.out.println("---------------------------------------");
        if (op.addEmployee(employee))
            System.out.println(name +" successfully added "+
                    "to the vector");
        else
            System.out.println("Error adding "+ name+
                    " to the vector");
        System.out.println("---------------------------------------");
    }

    public static void deleteEmployeeDetails() {
        e.opCount(2);
        System.out.print("Enter the name of the employee "+
                "you want to delete: ");
        String name = sc.nextLine();
        System.out.println("---------------------------------------");
        if (op.removeEmployee(name))
            System.out.println(name +" successfully "+
                    "deleted from the vector");
        else
            System.out.println(name +" was not found "+
                    "on the vector");
        System.out.println("---------------------------------------");
    }

    public static void compareEmployees() {
        System.out.print("Enter the name of first employee: ");
        String name1 = sc.nextLine();
        System.out.print("Enter the name of second employee: ");
        String name2 = sc.nextLine();
        op.compareEmployeeSalary(name1, name2);
    }

    public static void searchSpecificEmployee() {
        System.out.println("Search by\n"+
                "1 -> Name\n"+
                "2 -> ID");
        System.out.print("Enter your choice: ");
        String choice = sc.nextLine();
        Employee isExisting = null;
        if (choice.equals("1") || choice.equals("name") ||
            choice.equals("Name")) {
            System.out.print("Enter the name of the employee: ");
            String name = sc.nextLine();
            isExisting = op.specificEmployeeName(name);
        } else if (choice.equals("2") || choice.equals("id") ||
                choice.equals("ID")) {
            System.out.print("Enter the ID of the employee: ");
            String id = sc.nextLine();
            isExisting = op.specificEmployeeID(id);
        }
        if (isExisting == null) {
            System.out.println("Employee not found on the vector");
            return;
        }
        isExisting.printEmployeeDetails();
    }

    public static void printActionMenu() {
        System.out.println("1. Display the vector\n"+
                "2. Add employees to the vector\n"+
                "3. Remove employees from the vector\n"+
                "4. Compare two employees\n"+
                "5. Search for a specific employee\n"+
                "6. Sort the vector\n"+
                "7. See total number of instances created for employee\n"+
                "8. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void getCountOfInstances() {
        System.out.println("---------------------------------------");
        System.out.println("Total number of instances "+
                "created for Employee class -> "+ e.getCount());
        System.out.println("---------------------------------------");
    }
}
