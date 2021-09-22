package studentDatabaseApp2;

import java.util.Scanner;

public class studentDatabaseApp {

    public static void main(String[] args) {
        
        // Ask the new students will be added to the database
        System.out.print("Kérlek, add meg a hallgatók számát: ");
        Scanner be = new Scanner(System.in);
        int numberOfStudents = be.nextInt();
        student[] students = new student[numberOfStudents];
        
        // Create n number of students
        for (int i = 0; i < numberOfStudents; i++) {
            students[i] = new student();
            students[i].enroll();
            students[i].payTuition();
        }
        
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println(students[i].showInfo());
        }
    }

}
