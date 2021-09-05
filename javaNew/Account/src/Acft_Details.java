import java.util.Scanner;

public class Acft_Details extends Saving_Acc {
    private double deposits;
    private double withdrawals;
    private Scanner sc = new Scanner(System.in);
 
    public Acft_Details() {
        this.deposits = 0.0;
        this.withdrawals = 0.0;
    }

    @Override
    public void getData() {
        super.getData();
        System.out.print("Enter deposit amount: ");
        this.deposits = sc.nextDouble();
        System.out.print("Enter withdrawal amount: ");
        this.withdrawals = sc.nextDouble();
    }

    @Override
    public void putData() {
        super.putData();
        System.out.println("Deposits: "+ this.deposits +
                        "\nWithdrawals: "+ this.withdrawals);
    }
}
