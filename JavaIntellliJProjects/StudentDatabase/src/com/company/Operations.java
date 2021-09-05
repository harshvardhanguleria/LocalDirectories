package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Operations {
    private ArrayList<Student> list, sortedList;

    Operations() {
        this.list = new ArrayList<Student>();
    }

    void printStudents() {
        System.out.println("Student list");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("---------------------------------------");
            System.out.println("Student "+
                    (i+1) +". \n"+ "PRN -> "+
                    list.get(i).getPrn() +"\t"+
                    "Name -> "+
                    list.get(i).getName());
            System.out.println("Date of Birth -> "+
                    list.get(i).getDOB());
            System.out.println("Total marks -> "+
                    list.get(i).getTotal() +" out of 500");
            System.out.println("Percentage obtained -> "+
                    list.get(i).getPercentage());
            System.out.println("GPA obtained -> "+
                    list.get(i).getGPA());
            System.out.println("Grade obtained -> "+
                    list.get(i).getGrade());
            System.out.println("---------------------------------------");
        }
    }

    boolean addStudent(Student student) {
        if (findStudent(student.getName()) >= 0)
            return false;
        list.add(student);
        return true;
    }

    boolean removeStudent(Student student) {
        int foundStudent = findStudent(student);
        System.out.println("---------------------------------------");
        if (foundStudent < 0) {
            System.out.println(student.getName() +
                    ", was not found in the list");
            return false;
        }
        this.list.remove(foundStudent);
        System.out.println(student.getName() +
                ", was deleted");
        System.out.println("---------------------------------------");
        return false;
    }

    boolean updateStudent(Student oldDetail, Student newDetail) {
        int foundStudent = findStudent(oldDetail);
        System.out.println("---------------------------------------");
        if (foundStudent < 0) {
            System.out.println(oldDetail.getName() +
                    ", was not found");
            return false;
        } else if (findStudent(newDetail.getName()) != -1) {
            System.out.println(newDetail.getName() +
                    "already exists");
            return false;
        }
        this.list.set(foundStudent, newDetail);
        System.out.println(oldDetail.getName() +", was"+
                " replaced with "+ newDetail.getName());
        System.out.println("---------------------------------------");
        return true;
    }

    Student specificStudentName (String name) {
        int position = findStudent(name);
        if (position >= 0)
            return this.list.get(position);
        return null;
    }

    Student specificStudentPRN (String prn) {
        int position = findStudentPRN(prn);
        if (position >= 0)
            return this.list.get(position);
        return null;
    }

    Student specificStudentMarks (int choice, double marks) {
        int position = findStudentMarks(choice, marks);
        if (position >= 0)
            return this.list.get(position);
        return null;
    }

    void sortOnMarks() {
        sortedList = new ArrayList<Student>();
        for (Student s : list) {
            sortedList.add(s);
        }
        Collections.sort(sortedList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.valueOf(o2.getTotal()).compareTo(o1.getTotal());
            }
        });
        for (int i = 0; i < this.sortedList.size(); i++) {
            System.out.println("---------------------------------------");
            System.out.println((i + 1) + ". PRN -> " +
                    this.sortedList.get(i).getPrn() +
                    "\tName -> " +
                    this.sortedList.get(i).getName() +
                    "\nTotal Marks -> " +
                    this.sortedList.get(i).getTotal() +
                    "\nPercentage obtained -> " +
                    this.sortedList.get(i).getPercentage() +
                    "\nGPA obtained -> " +
                    this.sortedList.get(i).getGPA() +
                    "\nGrade obtained -> " +
                    this.sortedList.get(i).getGrade());
            System.out.println("---------------------------------------");
        }
    }

    void gradeCount() {
        System.out.println("---------------------------------------");
        System.out.println("Grade -> Number of students who "+
                "obtained that grade");
        System.out.println("---------------------------------------");
        String grade;
        int a = 0, bPlus = 0, b = 0, cPlus = 0, c = 0, f = 0;
        for (int i = 0; i < list.size(); i++) {
            grade = list.get(i).getGrade();
            if (grade.equals("A"))
                a += 1;
            else if (grade.equals("B+"))
                bPlus += 1;
            else if (grade.equals("B"))
                b += 1;
            else if (grade.equals("C+"))
                cPlus += 1;
            else if (grade.equals("C"))
                c += 1;
            else
                f += 1;
        }
        System.out.println("A -> "+ a);
        System.out.println("B+ -> "+ bPlus);
        System.out.println("B -> "+ b);
        System.out.println("C+ -> "+ cPlus);
        System.out.println("C -> "+ c);
        System.out.println("F -> "+ f);
        System.out.println("---------------------------------------");
    }

   private int findStudent (Student student) {
        return this.list.indexOf(student);
    }

    private int findStudent (String studentName) {
        for (int i = 0; i < this.list.size(); i++) {
            Student student = this.list.get(i);
            if (student.getName().equals(studentName))
                return i;
        }
        return -1;
    }

    private int findStudentPRN (String studentPRN) {
        for (int i = 0; i < this.list.size(); i++) {
            Student student = this.list.get(i);
            if (student.getPrn().equals(studentPRN))
                return i;
        }
        return -1;
    }

    private int findStudentMarks (int choice, double marks) {
        for (int i = 0; i < this.list.size(); i++) {
            Student student = this.list.get(i);
            if (choice == 1)
                if (student.getPercentage() == marks)
                    return i;
            else if (choice == 2)
                if (student.getGPA() == marks)
                    return i;
            else if (choice == 3)
                if (student.getTotal() == marks)
                    return i;
        }
        return -1;
    }
}
