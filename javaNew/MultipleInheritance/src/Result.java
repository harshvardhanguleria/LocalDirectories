public class Result extends Student implements Exam {
    private static Student s = new Student();
    private static double[] marks = s.getMarks();

    @Override
    public double percent_call() {
        double total = 0;
        for (int i = 0; i < 5; ++i) 
            total = total + marks[i];
        return (double)(total / 5);
    }

    public void input() {
        s.getDetails();
    }

    public void display() {
        System.out.println("\nName: "+ s.getName()+
                        "\nRoll no: "+ s.getRoll_no());
        for (int i = 0; i < 5; ++i) 
            System.out.println("Marks "+ (i+1) +": "+ marks[i]);
        System.out.println("Percentage: "+ percent_call());
    }
}
