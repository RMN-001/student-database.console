package studentDatabaseApp2;

import java.util.Scanner;

public class student {
    
    private String firstName;
    private String lastName;
    private String studentID;
    private static int id = 1000;
    private String gradeYear;
    private String courses = "";
    private int costOfCourse = 600;
    private int tuitionBalance;
        
    // Enter the name and year for each student
    public student() {
        Scanner be = new Scanner(System.in);
        System.out.print("Kérlek add meg a hallgató vezetéknevét: ");
        this.lastName = be.next();
        System.out.print("Kérlek add meg a hallgató keresztnevét: ");
        this.firstName = be.next();
        System.out.print("\nKérlek válaszd ki a hallgató képzési szintjét:\n"
                + " 1 - Elsõs\n"
                + " 2 - Másodikos\n"
                + " 3 - Harmadikos\n"
                + " 4 - Negyedikes");
        this.gradeYear = be.next();
        
        setStudentID();
    }
    
    // 5 digit unique ID, with the first number being the grade year
    private void setStudentID() {
        id++;
        this.studentID = gradeYear + id;
    }
    
    // Enrolling the following courses: History 101, Mathematics 101, English 101, Chemistry 101, Computer Science 101
    public void enroll() {
        System.out.println("\nVálaszd ki a hallgató által felvett kurzusokat a következõk közül, majd a Q megnyomásával haladj tovább: \n" 
                   + " Történelem 101\n" 
                   + " Angol 101\n"
                   + " Matematika 101\n"
                   + " Kémia 101\n"
                   + " Számítógépes tudományok 101\n"
                   + "\n"
                   + " Az alábbi kurzusokat választom:");
        do {
            Scanner be = new Scanner(System.in);
            String course = be.nextLine();
            if (!course.equals("Q")) {
                courses = courses + "\n " + course;
                tuitionBalance = tuitionBalance + costOfCourse;
            } else {
                break;
            }
       } while (1 != 0);
    }
    
    // Enrolling costs 600$ / course
    public void payTuition() {
        viewBalance();
        System.out.print("Add meg a befizetni kívánt összeget: $");
        Scanner be = new Scanner(System.in);
        int payment = be.nextInt();
        tuitionBalance = tuitionBalance - payment;
        if (payment > 0) {
            System.out.println("A befizetés sikeres volt.\n"
                + "Befizetett összeg: $" + payment);
        } else {
            System.out.println("Nem történt befizetés.");
        }
    }
    
    // Balance viewing and paying the tuition
    public void viewBalance() {
        System.out.println("\nAz egyenleged: $" + tuitionBalance);
    }
    
    public String showInfo() {
        return "\nNév: " + lastName + " " + firstName +
               "\nKépzési szint: " + gradeYear +
               "\nHallgatói azonosító: " + studentID +
               "\nFelvett kurzusok: " + courses +
               "\nEgyenleg: $" + tuitionBalance;
    }
}
