package model;

public class Student {

    private String name;
    private double gpa;

    private static int studentCount = 0;

    public Student(String name) {

        this(name, 0);
 
    }

    public Student(String name, double gpa) {

        setName(name);
        
        setGpa(gpa);

        ++studentCount;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if(gpa < 0) throw new RuntimeException("GPA must be non-negative");
        this.gpa = gpa;
    }

    public static int getStudentCount() {
        
        return studentCount;
    }

    public static void decrementStudentCount() {
        
        --studentCount;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", gpa=" + gpa + "]";
    }

    private void setName(String name) {
        if(name == null || name.isEmpty()) throw new RuntimeException("Student cannot be null and requres a name");
        this.name = name;
    }

}
