package main;

import model.Student;

public class Main {

    public static void main(String[] args) {
        
        System.out.println("Number of students: " + Student.getStudentCount());

        Student[] students = new Student[] {
            new Student("John"),
            new Student("Sam"),
            null,
            null
        };

        System.out.println("Number of students: " + Student.getStudentCount());

        {
            students[2] = new Student("John");
            students[3] = new Student("Sam");

            System.out.println("Number of students: " + Student.getStudentCount());

            students[2] = null; Student.decrementStudentCount();
            students[3] = null; Student.decrementStudentCount();
                        
        }

        System.out.println("Number of students: " + Student.getStudentCount());

        for(Student student : students) {
            System.out.println(student);
        }

    }

}
