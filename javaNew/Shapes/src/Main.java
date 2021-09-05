import java.util.Scanner;

public class Main {

    private static Scanner one = new Scanner(System.in);
    private static Scanner two = new Scanner(System.in);
    private static String color = "White";
    private static boolean filled = false;
    private static double radius = 0;
    private static double side = 0;
    private static double length = 0;
    private static double breadth = 0;
    private static Circle c = new Circle(radius, color, filled);
    private static Square s = new Square(side, color, filled);
    private static Rectazngle r = new Rectangle(length, breadth, color, filled);

    private static void showMenu(int choice) {
        if (choice == 1) {
            System.out.println("\n1. Circle"+
                                "\n2. Rectangle"+
                                "\n3. Square"+
                                "\n4. Exit");
        } else if (choice == 2) {
            System.out.println("\n1. Input details"+
                                "\n2. View Details");
        }
    }       

    public static void main(String[] args) {
        boolean exit = false;
        int choice;
        while (!exit) {
            showMenu(1);
            System.out.print("Enter your choice: ");
            choice = one.nextInt();
            switch(choice) {
                case 1:
                    circle();
                    break;
                case 2:
                    rectangle();
                    break;
                case 3:
                    square();
                    break;
                case 4:
                    exit = true;
                    break;
            }
        }
    }

    private static void circle() {
        showMenu(2);
        System.out.print("Enter your choice: ");
        int choice = one.nextInt();
        if (choice == 1) {
            System.out.print("Enter the radius: ");
            double radius = one.nextDouble();
            System.out.print("Is the circle filled with any color(true/false): ");
            filled = one.nextBoolean();
            if (filled) {
                System.out.print("Enter the color: ");
                color = two.nextLine();
            }
            c = new Circle(radius, color, filled);
            System.out.println("\nDetails of the circle");
            System.out.println("1. Radius: "+ c.getRadius());
            System.out.println("2. Area: "+ c.getArea());
            System.out.println("3. Perimeter: "+ c.getPerimeter());
            System.out.println(c.toString());
        } else if (choice == 2) {
            System.out.println("\nDetails of the circle");
            System.out.println("1. Radius: "+ c.getRadius());
            System.out.println("2. Area: "+ c.getArea());
            System.out.println("3. Perimeter: "+ c.getPerimeter());
            System.out.println(c.toString());
        }
    }

    private static void rectangle() {
        showMenu(2);
        System.out.print("Enter your choice: ");
        int choice = one.nextInt();
        if (choice == 1) {
            String color = "White";
            System.out.print("Enter the length: ");
            double length = one.nextDouble();
            System.out.print("Enter the breadth: ");
            double breadth = one.nextDouble();
            System.out.print("Is the rectangle filled with any color(true/false): ");
            boolean filled = one.nextBoolean();
            if (filled) {
                System.out.print("Enter the color: ");
                color = two.nextLine();
            }
            r = new Rectangle(length, breadth, color, filled);
            System.out.println("\nDetails of the Rectangle");
            System.out.println("1. Length: "+ r.getLength());
            System.out.println("2. Width: "+ r.getWidth());
            System.out.println("3. Area: "+ r.getArea());
            System.out.println("4. Perimeter: "+ r.getPerimeter());
            System.out.println(r.toString());
        } else if (choice == 2) {
            System.out.println("\nDetails of the Rectangle");
            System.out.println("1. Length: "+ r.getLength());
            System.out.println("2. Width: "+ r.getWidth());
            System.out.println("3. Area: "+ r.getArea());
            System.out.println("4. Perimeter: "+ r.getPerimeter());
            System.out.println(r.toString());
        }
    }

    private static void square() {
        showMenu(2);
        System.out.print("Enter your choice: ");
        int choice = one.nextInt();
        if (choice == 1) {
            String color = "White";
            System.out.print("Enter the side: ");
            double side = one.nextDouble();
            System.out.print("Is the square filled with any color(true/false): ");
            boolean filled = one.nextBoolean();
            if (filled) {
                System.out.print("Enter the color: ");
                color = two.nextLine();
            }
            s = new Square(side, color, filled);
            System.out.println("\nDetails of the Square");
            System.out.println("1. Side "+ s.getSide());
            System.out.println("2. Area: "+ s.getArea());
            System.out.println("3. Perimeter: "+ s.getPerimeter());
            System.out.println(s.toString());
        } else if (choice == 2) {
            System.out.println("\nDetails of the Square");
            System.out.println("1. Side "+ s.getSide());
            System.out.println("2. Area: "+ s.getArea());
            System.out.println("3. Perimeter: "+ s.getPerimeter());
            System.out.println(s.toString());
        }
    }
}
