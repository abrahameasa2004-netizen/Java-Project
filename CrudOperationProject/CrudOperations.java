package JDBC;
import java.sql.*;
import java.util.Scanner;

public class CrudOperations {
	private static final String URL = "jdbc:mysql://localhost/company";
	private static final String USER = "root";      
	private static final String PASSWORD = "Abraham"; 
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		try (Connection conn = DriverManager.getConnection(URL,USER, PASSWORD)) {
			System.out.println("✅ Connected to Database!");
			
			int choice;
			do {
				System.out.println("\n=== Employee Database App ===");
				System.out.println("1. Add Employee");
				System.out.println("2. View Employees");
				System.out.println("3. Update Employee");
				System.out.println("4. Delete Employee");
				System.out.println("5. Exit");
				System.out.print("Enter your choice: ");
				choice = sc.nextInt();
				sc.nextLine(); // consume newline
				
				switch (choice) {
				case 1 -> addEmployee(conn, sc);
				case 2 -> viewEmployees(conn);
				case 3 -> updateEmployee(conn, sc);
				case 4 -> deleteEmployee(conn, sc);
				case 5 -> System.out.println("Exiting...");
				default -> System.out.println("Invalid choice!");
				}
			} while (choice != 5);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		sc.close();
	}
	
	// CREATE
	private static void addEmployee(Connection conn, Scanner sc) throws SQLException {
		System.out.print("Enter Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Position: ");
		String position = sc.nextLine();
		System.out.print("Enter Salary: ");
		double salary = sc.nextDouble();
		
		String sql = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setString(2, position);
			pstmt.setDouble(3, salary);
			pstmt.executeUpdate();
			System.out.println("✅ Employee Added!");
		}
	}
	
	// READ
	private static void viewEmployees(Connection conn) throws SQLException {
		String sql = "SELECT * FROM employees";
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			
			System.out.println("\n--- Employee List ---");
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " | " +
						rs.getString("name") + " | " +
						rs.getString("position") + " | " +
						rs.getDouble("salary"));
			}
		}
	}
	
	// UPDATE
	private static void updateEmployee(Connection conn, Scanner sc) throws SQLException {
		System.out.print("Enter Employee ID to update: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter new Position: ");
		String position = sc.nextLine();
		System.out.print("Enter new Salary: ");
		double salary = sc.nextDouble();
		
		String sql = "UPDATE employees SET position = ?, salary = ? WHERE id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, position);
			pstmt.setDouble(2, salary);
			pstmt.setInt(3, id);
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("✅ Employee Updated!");
			} else {
				System.out.println("⚠️ Employee not found!");
			}
		}
	}
	
	// DELETE
	private static void deleteEmployee(Connection conn, Scanner sc) throws SQLException {
		System.out.print("Enter Employee ID to delete: ");
		int id = sc.nextInt();
		
		String sql = "DELETE FROM employees WHERE id = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				System.out.println("✅ Employee Deleted!");
			} else {
				System.out.println("⚠️ Employee not found!");
			}
		}
	}
}




