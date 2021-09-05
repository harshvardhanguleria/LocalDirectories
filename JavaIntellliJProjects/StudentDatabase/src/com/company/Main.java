package com.company;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static Operations op = new Operations();

    public static void main(String[] args) {
        boolean exit = false;
        int action;
        Scanner sc = new Scanner(System.in);
        while (!exit) {
            System.out.println();
            printActionMenu();
            System.out.print("Enter your "+
                    "choice of action: ");
            action = sc.nextInt();
            switch(action) {
                case 1:
                    op.printStudents();
                    break;
                case 2:
                    inputStudentDetails();
                    break;
                case 3:
                    updateStudentDetails();
                    break;
                case 4:
                    removeStudentDetails();
                    break;
                case 5:
                    searchForSpecificStudent();
                    break;
                case 6:
                    op.gradeCount();
                    break;
                case 7:
                    op.sortOnMarks();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
        sc.close();
    }

    private static void inputStudentDetails() {
        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter student prn: ");
        String prn = sc.nextLine();
        double[] marks = new double[5];
        String[] subjects = new String[5];
        System.out.println("Enter date of birth");
        System.out.print("Enter date: ");
        String date = sc.nextLine();
        System.out.print("Enter month: ");
        String month = sc.nextLine();
        System.out.print("Enter year: ");
        String year = sc.nextLine();
        System.out.println("Enter the names of 5 subjects and "+
                "marks in them");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject "+ (i+1) + " -> ");
            subjects[i] = sc.nextLine();
            System.out.print("Marks "+ (i+1) +" -> ");
            marks[i] = sc.nextDouble();
            sc.nextLine();
        }
        Student student = Student.createStudent(name, prn,
                subjects, marks, date, month, year);
        System.out.println("---------------------------------------");
        if (op.addStudent(student))
            System.out.println("New student "+ name
                    +" added");
        else
            System.out.println(name +"already on the list");
        System.out.println("---------------------------------------");
    }

    public static void updateStudentDetails() {
        System.out.print("Enter name of the student whose "+
                "details you want to update: ");
        String name = sc.nextLine();
        Student isExisting = op.specificStudentName(name);
        if (isExisting == null) {
            System.out.println("Student not found");
            return;
        }
        System.out.print("Enter student name: ");
        String studentName = sc.nextLine();
        System.out.print("Enter student prn: ");
        String prn = sc.nextLine();
        double[] marks = new double[5];
        String[] subjects = new String[5];
        System.out.println("Enter date of birth");
        System.out.print("Enter date: ");
        String date = sc.nextLine();
        System.out.print("Enter month: ");
        String month = sc.nextLine();
        System.out.print("Enter year: ");
        String year = sc.nextLine();
        System.out.println("Enter the names of 5 subjects and "+
                "marks in them");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject "+ (i+1) + " -> ");
            subjects[i] = sc.nextLine();
            System.out.print("Marks "+ (i+1) +" -> ");
            marks[i] = sc.nextDouble();
            sc.nextLine();
        }
        Student updatedStudent = Student.createStudent(studentName,
                prn, subjects, marks, date, month, year);
        System.out.println("---------------------------------------");
        if (op.updateStudent(isExisting, updatedStudent))
            System.out.println("Successfully updated the record");
        else
            System.out.println("Error updating the record");
        System.out.println("---------------------------------------");
    }

    public static void removeStudentDetails() {
        System.out.print("Enter student's name: ");
        String name = sc.nextLine();
        Student isExisting = op.specificStudentName(name);
        if (isExisting == null) {
            System.out.println("Student not found");
            return;
        }
        System.out.println("---------------------------------------");
        if (op.removeStudent(isExisting))
            System.out.println("Successfully deleted the record");
        else
            System.out.println("Error deleting the record");
        System.out.println("---------------------------------------");
    }

    public static void searchForSpecificStudent() {
        Student isExisting = null;
        System.out.println("Search by \n"+
                "1 -> Name\n"+
                "2 -> PRN\n"+
                "3 -> Marks");
        System.out.print("Enter your choice: ");
        String choice = sc.nextLine();
        if (choice.equals("1") || choice.equals("name") ||
            choice.equals("Name")) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            isExisting = op.specificStudentName(name);
        } else if (choice.equals("2") || choice.equals("PRN") ||
                choice.equals("prn")) {
            System.out.print("Enter student PRN: ");
            String prn = sc.nextLine();
            isExisting = op.specificStudentPRN(prn);
        } else if (choice.equals("3") || choice.equals("Marks") ||
                choice.equals("marks")) {
            System.out.print("1 -> Percentage\n"+
                    "2 -> GPA\n"+
                    "3 -> Total Marks");
            String marks = sc.nextLine();
            if (marks.equals("1") || marks.equals("percentage") ||
                marks.equals("Percentage")) {
                System.out.print("Enter percentage: ");
                double percentage = sc.nextDouble();
                isExisting = op.specificStudentMarks(1, percentage);
            } else if (marks.equals("2") || marks.equals("gpa") ||
                    marks.equals("GPA")) {
                System.out.print("Enter gpa: ");
                double gpa = sc.nextDouble();
                isExisting = op.specificStudentMarks(2, gpa);
            } else if (marks.equals("3") || marks.equals("total marks") ||
                    marks.equals("Total Marks")) {
                System.out.print("Enter total marks: ");
                double total = sc.nextDouble();
                isExisting = op.specificStudentMarks(3, total);
            }
        }
        if (isExisting == null) {
            System.out.println("Student not found");
            return;
        }
        isExisting.printStudentDetails();
    }

    private static void printActionMenu() {
        System.out.println("1. Display the list\n"+
                "2. Add students to the list\n"+
                "3. Update the details of the students\n"+
                "4. Delete record of students\n"+
                "5. Search for a specific student\n"+
                "6. See the grade count of all the students\n"+
                "7. Get a sorted list of students on the basis of marks\n"+
                "8. Exit\n");
    }
}
