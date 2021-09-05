import java.util.Scanner;

public class Account {
    private String cust_name;
    private String acc_no;
    private Scanner sc = new Scanner(System.in);
 
    public Account() {
        this.cust_name = null;
        this.acc_no = null;
    }   

    public void getData() {
        System.out.print("Enter customer name: ");
        this.cust_name = sc.nextLine();
        System.out.print("Enter account number: ");
        this.acc_no = sc.nextLine();
    }

    public void putData() {
        System.out.println("\nName: "+ this.cust_name +
                    "\nAccount no: "+ this.acc_no);
    }
}
