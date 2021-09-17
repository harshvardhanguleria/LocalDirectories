import java.sql.*;

public class Operations {
    private static final String url = "jdbc:mysql://localhost:3306/Employee";
    private static final String username = "root";
    private static final String password = "AbcD123#";
    private static final String className = "com.mysql.cj.jdbc.Driver";
    private static String query;
    
    public boolean addEmployee(int empno, String ename, String department, 
                        String job, double salary) {
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, username, password);
            query = "insert into Employee values("+ empno +", '"+ ename +"', '"+ 
                    department +"', '"+ job + "', "+ salary +");";
            PreparedStatement prep = con.prepareStatement(query);
            prep.execute();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void viewEmployees() {
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, username, password);
            query = "select * from Employee ;";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.print("------------------------------------------------------------------");
            System.out.println("\nempno \t ename \t department \t job \t     Salary");
            System.out.println("------------------------------------------------------------------");
            while (rs.next()) {
                System.out.format("%-9s%-11s%-12s%-13s%-8s%n", rs.getString(1), rs.getString(2),
                                rs.getString(3), rs.getString(4), rs.getString(5));
            }
            System.out.println("------------------------------------------------------------------");
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean searchEmployee(String name) {
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, username, password);
            query = "select * from Employee where ename='"+ name +"';";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            System.out.print("------------------------------------------------------------------");
            System.out.println("\nempno \t ename \t department \t job \t     Salary");
            System.out.println("------------------------------------------------------------------");
            while (rs.next()) {
                System.out.format("%-9s%-11s%-12s%-13s%-8s%n", rs.getString(1), rs.getString(2),
                                rs.getString(3), rs.getString(4), rs.getString(5));
            }
            System.out.println("------------------------------------------------------------------");
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean updateEmployee(int empno, String ename, String department,
                        String job, double salary) {
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, username, password);
            query = "update Employee set empno="+ empno +", ename='"+ ename +"', "+
                "department='"+department +"', job='"+ job +"', salary="+
                salary +" where empno="+ empno +";";
            PreparedStatement prep = con.prepareStatement(query);
            prep.execute();
            con.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public boolean removeEmployee(int empno) {
        try {
            Class.forName(className);
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            query = "delete from Employee where empno="+ empno +";";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}