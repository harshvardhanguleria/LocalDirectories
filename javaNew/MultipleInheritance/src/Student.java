import java.util.Scanner;
 
public class Student {
    private String name;
    private String roll_no;
    private double[] marks = new double[5];
    private static Scanner sc = new Scanner(System.in);

    public Student() {
        this.name = null;
        this.roll_no = null;
        for (int i = 0; i < 5; ++i) 
            marks[i] = 0.0;
    }

    public void getDetails() {
        System.out.print("Enter student's name: ");
        this.name = sc.nextLine();
        System.out.print("Enter student's roll number: ");
        this.roll_no = sc.nextLine();
        System.out.println("Enter the marks");
        for (int i = 0; i < 5; ++i) {
            System.out.print("Marks in subject "+ (i+1) +": ");
            this.marks[i] = sc.nextDouble();
        } 
    }

    public String getName() { return this.name; }
    public String getRoll_no() { return this.roll_no; }
    public double[] getMarks() { return this.marks; }
}
