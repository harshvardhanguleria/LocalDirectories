import java.util.Scanner;
 
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Result r = new Result();

    public static void printMenu() {
        System.out.println("\n1. Input details"+
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
                    r.input();
                    break;
                case 2:
                    r.display();
                    break;
                case 3:
                    exit = true;
                    break;
            }
        }
    }
}
