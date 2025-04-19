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
}
