import java.util.Scanner;

public class Saving_Acc extends Account {
    private double min_bal;
    private double saving_bal;
    private static Scanner sc = new Scanner(System.in);
     
    public Saving_Acc() {
        this.min_bal = 0.0;
        this.saving_bal = 0.0;
    }

    @Override
    public void getData() {
        super.getData();
        System.out.print("Enter minimum balance: ");
        this.min_bal = sc.nextDouble();
        System.out.print("Enter balance in savings account: ");
        this.saving_bal = sc.nextDouble();
    }

    @Override
    public void putData() {
        super.putData();
        System.out.println("Minimum balance: "+ this.min_bal +
                    "\nSavings amount: "+ this.saving_bal);
    }
}
