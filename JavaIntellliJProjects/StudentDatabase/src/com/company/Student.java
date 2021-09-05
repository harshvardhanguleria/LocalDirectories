package com.company;

public class Student {
    private String prn;
    private String name;
    private double[] marks;
    private String[] subjects;
    private double total;
    DOB dob = new DOB();

    public Student(String name, String prn,
                   String[] subjects, double[] marks,
                   String date, String month, String year) {
        this.prn = prn;
        this.name = name;
        this.marks = marks;
        this.subjects = subjects;
        this.total = 0;
        dob.setDOB(date, month, year);
    }

    public String getName() { return name; }
    public String getPrn() { return prn; }
    public String getDOB() { return dob.getDOB(); }

    public static Student createStudent(String name,
                                        String prn,
                                        String[] subjects,
                                        double[] marks,
                                        String date,
                                        String month,
                                        String year) {
        return new Student(name, prn, subjects, marks,
                date, month, year);
    }

    public double getTotal() {
        this.total = 0;
        for (int i = 0; i < 5; i++)
            total = total + marks[i];
        return total;
    }

    public double getPercentage() {
        return total / 5;
    }

    public double getGPA() {
        return getPercentage() / 10;
    }

    public void printSubjectsMarks() {
        for (int i = 0; i < 5; i++)
            System.out.println(subjects[i] +" -> "+
                        marks[i]);
    }

    String getGrade() {
        double percentage = getPercentage();
        if (percentage >= 90 && percentage < 100)
            return "A";
        else if (percentage >= 80 && percentage < 90)
            return "B+";
        else if (percentage >= 70 && percentage < 80)
            return "B";
        else if (percentage >= 60 && percentage < 70)
            return "C+";
        else if (percentage >= 40 && percentage < 60)
            return "C";
        else
            return "F";
    }

    public void printStudentDetails() {
        System.out.println("---------------------------------------");
        System.out.println("The student details are as follows");
        System.out.println("---------------------------------------");
        System.out.println("PRN -> "+
                getPrn() +"\t"+ "Name -> "+ getName());
        System.out.println("Date of Birth -> "+ getDOB());
        System.out.println("Marks obtained in each subject");
        printSubjectsMarks();
        System.out.println("Total marks -> "+
                getTotal() +" out of 500");
        System.out.println("Percentage obtained -> "+
                getPercentage());
        System.out.println("GPA obtained -> "+
                getGPA());
        System.out.println("Grade obtained -> "+
                getGrade());
        System.out.println("---------------------------------------");
    }
}
