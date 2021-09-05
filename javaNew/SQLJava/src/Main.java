import java.util.Scanner;

public class Main {
	private static Scanner sc = new Scanner(System.in);
	private static Operations op = new Operations();

	public static void printActions() {
		System.out.print("\n1. Add employee details"+
							"\n2. View the employee table"+
							"\n3. Edit employee details"+
							"\n4. Remove employee"+
							"\n5. Search employee"+
							"\n6. Exit"+
							"\nEnter your choice: ");
	}

    public static void main(String[] args) {
        boolean exit = false;
        int choice;
        while (!exit) {
        	printActions();
        	choice = Integer.parseInt(sc.nextLine());
        	switch(choice) {
	        	case 1:
	        		insert();
	        		break;
	        	case 2:
	        		op.viewEmployees();
	        		break;
	        	case 3:
	        		edit();
	        		break;
	        	case 4:
	        		remove();
	        		break;
	        	case 5:
	        		search();
	        		break;
	        	case 6:
	        		exit = true;
	        		break;
	        }
        }
    }

    private static void insert() {
    	String name, department, job;
    	int no;
    	double salary;
    	System.out.print("\nEnter employee no: ");
    	no = Integer.parseInt(sc.nextLine());
    	System.out.print("\nEnter name: ");
    	name = sc.nextLine();
    	System.out.print("\nEnter department: ");
    	department = sc.nextLine();
    	System.out.print("\nEnter job: ");
    	job = sc.nextLine();
    	System.out.print("\nEnter salary: ");
    	salary = Double.parseDouble(sc.nextLine());
    	if (op.addEmployee(no, name, department, job, salary))
    		System.out.println("\nInsertion successful");
    	else
    		System.out.println("\nError inserting employee");
    }

    private static void edit() {
    	String name, department, job;
    	int no;
    	double salary;
    	System.out.print("\nEnter employee no: ");
    	no = Integer.parseInt(sc.nextLine());
    	System.out.print("\nEnter name: ");
    	name = sc.nextLine();
    	System.out.print("\nEnter department: ");
    	department = sc.nextLine();
    	System.out.print("\nEnter job: ");
    	job = sc.nextLine();
    	System.out.print("\nEnter salary: ");
    	salary = Double.parseDouble(sc.nextLine());
    	if (op.updateEmployee(no, name, department, job, salary))
    		System.out.println("\nUpdated successfully");
    	else
    		System.out.println("\nError updating employee");	
    }

    private static void remove() {
    	int no;
    	System.out.print("\nEnter employee no: ");
    	no = Integer.parseInt(sc.nextLine());
    	if (op.removeEmployee(no))
    		System.out.println("\nSuccessfully removed employee");
    	else
    		System.out.println("\nError removing employee");		
    }

    private static void search() {
    	String name;
    	System.out.print("\nEnter name: ");
    	name = sc.nextLine();
    	if (!op.searchEmployee(name))
    		System.out.println("\nEmployee not found");
    }
}
