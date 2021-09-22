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
        System.out.print("K�rlek add meg a hallgat� vezet�knev�t: ");
        this.lastName = be.next();
        System.out.print("K�rlek add meg a hallgat� keresztnev�t: ");
        this.firstName = be.next();
        System.out.print("\nK�rlek v�laszd ki a hallgat� k�pz�si szintj�t:\n"
                + " 1 - Els�s\n"
                + " 2 - M�sodikos\n"
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
        System.out.println("\nV�laszd ki a hallgat� �ltal felvett kurzusokat a k�vetkez�k k�z�l, majd a Q megnyom�s�val haladj tov�bb: \n" 
                   + " T�rt�nelem 101\n" 
                   + " Angol 101\n"
                   + " Matematika 101\n"
                   + " K�mia 101\n"
                   + " Sz�m�t�g�pes tudom�nyok 101\n"
                   + "\n"
                   + " Az al�bbi kurzusokat v�lasztom:");
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
        System.out.print("Add meg a befizetni k�v�nt �sszeget: $");
        Scanner be = new Scanner(System.in);
        int payment = be.nextInt();
        tuitionBalance = tuitionBalance - payment;
        if (payment > 0) {
            System.out.println("A befizet�s sikeres volt.\n"
                + "Befizetett �sszeg: $" + payment);
        } else {
            System.out.println("Nem t�rt�nt befizet�s.");
        }
    }
    
    // Balance viewing and paying the tuition
    public void viewBalance() {
        System.out.println("\nAz egyenleged: $" + tuitionBalance);
    }
    
    public String showInfo() {
        return "\nN�v: " + lastName + " " + firstName +
               "\nK�pz�si szint: " + gradeYear +
               "\nHallgat�i azonos�t�: " + studentID +
               "\nFelvett kurzusok: " + courses +
               "\nEgyenleg: $" + tuitionBalance;
    }
}
