import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    private static Calculator c = new Calculator();
    private static RationalNumber result;
    private static int num1 = 0;
    private static int num2 = 0;
    private static int denom1 = 0;
    private static int denom2 = 0;

    private static void printMenu() {
        System.out.print("\n1. Add"+
                        "\n2. Subtract"+
                        "\n3. Multiply"+
                        "\n4. Divide"+
                        "\n5. Compare"+
                        "\n6. Convert to floating point"+
                        "\n7. Get Absolute value"+
                        "\n8. Exit"+
                        "\nEnter your choice: ");
    }

    public static void main(String[] args) {
        boolean exit = false;
        int choice = 1;
        RationalNumber one;
        RationalNumber two;
        Scanner sc = new Scanner(System.in);
        while (!exit) {
            try {
                System.out.println("\nRational number of the form a/b");
                System.out.print("Enter a: ");
                num1 = sc.nextInt();
                do {
                    System.out.print("Enter b: ");
                    denom1 = sc.nextInt();
                }while(denom1 == 0);
                System.out.println("Second rational number");
                System.out.print("Enter a: ");
                num2 = sc.nextInt();
                do {
                    System.out.print("Enter b: ");
                    denom2 = sc.nextInt();
                }while(denom2 == 0);
            } catch (InputMismatchException a) {
                System.out.println(a.getMessage());
            }
            try {
                sc.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println(e.getMessage());
            }
            printMenu();
            choice = sc.nextInt();
            one = new RationalNumber(num1, denom1);
            two = new RationalNumber(num2, denom2);
            switch(choice) {
                case 1:
                    addition(one, two);
                    break;
                case 2:
                    subtraction(one, two);
                    break;
                case 3:
                    multiplication(one, two);
                    break;
                case 4:
                    division(one, two);
                    break;
                case 5:
                    comparison(one, two);
                    break;
                case 6:
                    floatingPoint(one);
                    break;
                case 7:
                    absoluteValue(one);
                    break;
                case 8:
                    exit = true;
                    break;
            }
        }
        sc.close();
    }

    private static void addition(RationalNumber one, 
            RationalNumber two) {
        try {
            result = c.add(one, two);
            System.out.println(one +" + "+ two +" = "+ result +"\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void subtraction(RationalNumber one, 
            RationalNumber two) {
        try {
            result = c.subtract(one, two);
            System.out.println(one +" - "+ two +" = "+ result +"\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void multiplication(RationalNumber one,
            RationalNumber two) {
        try {
            result = c.multiply(one, two);
            System.out.println(one +" * "+ two +" = "+ result +"\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void division(RationalNumber one,
            RationalNumber two) {
        try {
            result = c.divide(one, two);
            System.out.println(one +" / "+ two +" = "+ result +"\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void comparison(RationalNumber one, 
            RationalNumber two) {
        try {
            int res = c.compare(one, two);
            if (res == 1)
                System.out.println(one +" > "+ two +"\n");
            else if (res == 0)
                System.out.println(one +" = "+ two +"\n");
            else if (res == -1)
                System.out.println(one +" < "+ two +"\n");
            else 
                System.out.println("Error");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void floatingPoint(RationalNumber one) {
        try {
            double res = c.convertToFloatingPoint(one);
            System.out.println(one +" = "+ res +"\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void absoluteValue(RationalNumber one) {
        try {
            double res = c.getAbsoluteValue(one);
            System.out.println("Absolute value of "+ one +" = "+ res +"\n");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}