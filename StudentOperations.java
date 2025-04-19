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
}
