// StudentOperations.java
import java.sql.*;
import java.util.*;

public class StudentOperations {
    private Connection conn;
    private static final String URL="jdbc:mysql://localhost:3306/db_schema";
    private static final String USER="root";
    private static final String PASSWORD="PASSWORD";

    public StudentOperations() {
        try {
            // establish connection with DBMS
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to Add Student
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (prn, name, branch, batch, cgpa) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, student.getPrn());
            stmt.setString(2, student.getName());
            stmt.setString(3, student.getBranch());
            stmt.setString(4, student.getBatch());
            stmt.setDouble(5, student.getCgpa());
            stmt.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    // Method to Display all students
    public void displayStudents() {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                Student s = new Student(
                        rs.getLong("prn"),
                        rs.getString("name"),
                        rs.getString("branch"),
                        rs.getString("batch"),
                        rs.getDouble("cgpa")
                );
                s.display();
            }
        } catch (SQLException e) {
            System.out.println("Error displaying students: " + e.getMessage());
        }
    }

    // Method to Search by PRN
    public Student searchByPRN(long prn) {
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM students WHERE prn = ?")) {
            stmt.setLong(1, prn);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(prn, rs.getString("name"), rs.getString("branch"), rs.getString("batch"), rs.getDouble("cgpa"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    // Method to Search by Name
    public Student searchByName(String name) {
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * FROM students WHERE name = ?")) {
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(rs.getLong("prn"), name, rs.getString("branch"), rs.getString("batch"), rs.getDouble("cgpa"));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }
}
