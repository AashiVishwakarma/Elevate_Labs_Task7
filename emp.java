import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class emp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DBConnection dbconn=new DBConnection();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Employee", "root", "A@SHI1121");
            System.out.println("DB Connected successfully!");
            conn.close();
        boolean running = true;
        while (running) {
            System.out.println("\n--- Employee Database App ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    dbconn.insertEmployee();
                    break;
                case 2:
                    dbconn.viewEmployees();
                    break;

                case 3:
                    dbconn.updateEmployee();
                    break;

                case 4:
                    dbconn.deleteEmployee();
                    break;

                case 5 :
                    running = false;
                    System.out.println("Exiting program...!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
