import java.sql.*;
import java.util.Scanner;

class DBConnection {
    static Scanner sc=new Scanner(System.in);
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Employee";
        String user = "root";
        String password = "A@SHI1121";
        return DriverManager.getConnection(url, user, password);
    }
    public void insertEmployee() {
        System.out.print("Id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Department: ");
        String dept = sc.nextLine();
        System.out.print("Salary: ");
        double salary = sc.nextDouble();
        String query = "INSERT INTO employee_details (id, name, dept, salary) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, dept);
            stmt.setDouble(4, salary);
            stmt.executeUpdate();
            System.out.println("Employee details inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void viewEmployees() {
        String query = "SELECT * FROM employee_details";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name")
                        + " " + rs.getString("dept")+ " " + rs.getDouble("salary"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        String checkQuery = "SELECT COUNT(*) FROM employee_details WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {

            checkStmt.setInt(1, id);
            ResultSet rs = checkStmt.executeQuery();
            rs.next();
            if (rs.getInt(1) == 0) {
                System.out.println("Employee with ID - " + id + " not found!");
                return;
            }

            System.out.println("What do you want to update?");
            System.out.println("1. Name");
            System.out.println("2. Department");
            System.out.println("3. Salary");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            String query = "";
            PreparedStatement ps = null;

            switch (choice) {
                case 1:
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    query = "UPDATE employee_details SET name=? WHERE id=?";
                    ps = conn.prepareStatement(query);
                    ps.setString(1, newName);
                    ps.setInt(2, id);
                    break;

                case 2:
                    System.out.print("Enter new department: ");
                    String newDept = sc.nextLine();
                    query = "UPDATE employee_details SET dept=? WHERE id=?";
                    ps = conn.prepareStatement(query);
                    ps.setString(1, newDept);
                    ps.setInt(2, id);
                    break;

                case 3:
                    System.out.print("Enter new salary: ");
                    double newSalary = sc.nextDouble();
                    query = "UPDATE employee_details SET salary=? WHERE id=?";
                    ps = conn.prepareStatement(query);
                    ps.setDouble(1, newSalary);
                    ps.setInt(2, id);
                    break;

                default:
                    System.out.println("Invalid choice!");
                    return;
            }

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee details updated successfully!");
            } else {
                System.out.println("Update failed!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteEmployee() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        String query = "DELETE FROM employee_details WHERE id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Employee details deleted successfully");
            } else {
                System.out.println("Employee with ID - " + id + " not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}