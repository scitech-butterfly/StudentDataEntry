// Student.java

public class Student {
    private long prn;
    private String name;
    private String branch;
    private String batch;
    private double cgpa;

    // Parameterized Constructor
    public Student(long prn, String name, String branch, String batch, double cgpa) {
        this.prn = prn;
        this.name = name;
        this.branch = branch;
        this.batch = batch;
        this.cgpa = cgpa;
    }

    // Getter-Setter Methods for Private Members
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPRN() {
        return prn;
    }

    public void setPRN(long prn) {
        this.prn = prn;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public double getCGPA() {
        return cgpa;
    }

    public void setCGPA(double cgpa) {
        this.cgpa = cgpa;
    }

    // Display Student Details
    public void display() {
        System.out.printf("\nPRN: %d | Name: %s | Branch: %s | Batch: %s | CGPA: 2f\n", prn, name, branch, batch, cgpa);
    }
}
