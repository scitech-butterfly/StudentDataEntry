// Name: Kashvi Singh
// PRN: 23070126057
// Batch: AIML A3

// Main.java

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in); // To take user input
    StudentOperations operations = new StudentOperations(); // Instance of StudentOperations

    while (true) {
      // Display Menu
      System.out.println("\nMenu:");
      System.out.println("1. Add Student");
      System.out.println("2. Display Students");
      System.out.println("3. Search Student by PRN");
      System.out.println("4. Search Student by Name");
      System.out.println("5. Search Student by Position");
      System.out.println("6. Update Student Details");
      System.out.println("7. Delete Student");
      System.out.println("0. Exit");
      System.out.print("Enter your choice: ");

      // Take integer input for user-choice
      int choice = Integer.parseInt(scan.nextLine());

      // Exit the program if choice is 0
      if (choice == 0) {
        System.out.println("Exiting the program...");
        break;
      }

      switch (choice) {
        case 1: // Add Student
          System.out.print("Enter Name: ");
          String name = scan.nextLine();
          System.out.print("Enter PRN: ");
          long prn = Long.parseLong(scan.nextLine());
          System.out.print("Enter Branch: ");
          String branch = scan.nextLine();
          System.out.print("Enter Batch: ");
          String batch = scan.nextLine();
          System.out.print("Enter CGPA: ");
          double cgpa = Double.parseDouble(scan.nextLine());

          Student student = new Student(prn, name, branch, batch, cgpa);
          operations.addStudent(student);
          break;

        case 2: // Display Students
          operations.displayStudents();
          break;

        case 3: // Search Student by PRN
          System.out.print("Enter PRN to search: ");
          prn = Long.parseLong(scan.nextLine());
          Student foundByPrn = operations.searchByPRN(prn);
          if (foundByPrn != null) {
            foundByPrn.display();
          } else {
            System.out.println("Student not found.");
          }
          break;

        case 4: // Search Student by Name
          System.out.print("Enter Name to search: ");
          name = scan.nextLine();
          Student foundByName = operations.searchByName(name);
          if (foundByName != null) {
            foundByName.display();
          } else {
            System.out.println("Student not found.");
          }
          break;

        case 5: // Search Student by Position
          System.out.print("Enter position (index starts from 0): ");
          int position = Integer.parseInt(scan.nextLine());
          Student foundByPosition = operations.searchByPosition(position);
          if (foundByPosition != null) {
            foundByPosition.display();
          }
          break;

        case 6: // Update Student
          System.out.print("Enter PRN to update: ");
          prn = Long.parseLong(scan.nextLine());
          System.out.print("Enter New Name: ");
          name = scan.nextLine();
          System.out.print("Enter New Branch: ");
          branch = scan.nextLine();
          System.out.print("Enter New Batch: ");
          batch = scan.nextLine();
          System.out.print("Enter New CGPA: ");
          cgpa = Double.parseDouble(scan.nextLine());

          operations.updateStudent(new Student(prn, name, branch, batch, cgpa));
          break;

        case 7: // Delete Student
          System.out.print("Enter PRN to delete: ");
          prn = Long.parseLong(scan.nextLine());
          operations.deleteStudent(prn);
          break;

        default:
          System.out.println("Invalid choice! Please enter a valid option.");
      }
    }
    scan.close();
  }
}
