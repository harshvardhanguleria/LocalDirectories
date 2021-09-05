package com.company;

public class Employee {
    private String name;
    private String id;
    private String gender;
    private String jobTitle;
    private String organization;
    private double salary;
    private static int count = 0;

    public Employee() {}

    public Employee(String name, String id, String gender,
                    String jobTitle, String organization,
                    double salary) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.jobTitle = jobTitle;
        this.organization = organization;
        this.salary = salary;
    }

    void opCount(int option) {
        if (option == 1)
            count++;
        else if (option == 2 && count > 0)
            count–-;
        else
            return;
    }


    public String getName() { return name; }
    public String getID() { return id; }
    public String getGender() { return gender; }
    public String getJobTitle() { return jobTitle; }
    public String getOrganization() { return organization; }
    public double getSalary() { return salary; }
    public int getCount() { return count; }

    public static Employee createEmployee(String name, String id,
                                          String gender, String jobTitle,
                                          String organization,
                                          double salary) {
        return new Employee(name, id, gender, jobTitle, organization, salary);
    }

    void printEmployeeDetails() {
        System.out.println("---------------------------------------");
        System.out.println("ID -> "+ getID() +
                "\nName -> "+ getName() +
                "\nSex -> "+ getGender() +
                "\nJobTitle -> "+ getJobTitle() +
                "\nOrganization -> "+ getOrganization() +
                "\nSalary -> "+ getSalary());
        System.out.println("---------------------------------------");
    }
}
