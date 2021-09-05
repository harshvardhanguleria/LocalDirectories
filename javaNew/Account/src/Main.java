import java.util.Scanner;

public class Main {
    private static Acft_Details a = new Acft_Details();
    private static Scanner sc = new Scanner(System.in);
 
    public static void printMenu() {
        System.out.println("\n1. Enter details"+
                        "\n2. Print details"+
                        "\n3. Exit");
    }

    public static void main(String[] args) {
        boolean exit = false;
        int choice;
        while (!exit) {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    a.getData();
                    break;
                case 2:
                    a.putData();
                    break;
                case 3:
                    exit = true;
                    break;
            }
        }
    }
}
