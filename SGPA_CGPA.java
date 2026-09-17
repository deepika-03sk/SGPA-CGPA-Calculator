import java.util.Scanner;

public class SGPA_CGPA {

    // Convert marks to grade points
    static int getGradePoint(int marks) {
        if (marks >= 90)
            return 10;
        else if (marks >= 80)
            return 9;
        else if (marks >= 70)
            return 8;
        else if (marks >= 60)
            return 7;
        else if (marks >= 50)
            return 6;
        else if (marks >= 40)
            return 5;
        else
            return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Student Details
        System.out.println("===== STUDENT DETAILS =====");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        String rollNo = sc.nextLine();

        System.out.print("Enter Branch: ");
        String branch = sc.nextLine();

        // Number of subjects
        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        double totalCredits = 0;
        double totalPoints = 0;

        // Enter subject details
        for (int i = 1; i <= n; i++) {

            System.out.println("\nSubject " + i);

            System.out.print("Enter Credits: ");
            double credit = sc.nextDouble();

            System.out.print("Enter Marks: ");
            int marks = sc.nextInt();

            int gradePoint = getGradePoint(marks);

            totalCredits = totalCredits + credit;
            totalPoints = totalPoints + (credit * gradePoint);
        }

        // SGPA
        double sgpa = totalPoints / totalCredits;

        // CGPA
        System.out.print("\nEnter number of completed semesters: ");
        int semesters = sc.nextInt();

        double sum = sgpa;

        for (int i = 2; i <= semesters; i++) {

            System.out.print("Enter SGPA of Semester " + i + ": ");
            double previousSGPA = sc.nextDouble();

            sum = sum + previousSGPA;
        }

        double cgpa = sum / semesters;

        // Display Result
        System.out.println("\n================================");
        System.out.println("          STUDENT RESULT");
        System.out.println("================================");

        System.out.println("Student Name : " + name);
        System.out.println("Roll Number  : " + rollNo);
        System.out.println("Branch       : " + branch);

        System.out.printf("SGPA         : %.2f%n", sgpa);
        System.out.printf("CGPA         : %.2f%n", cgpa);

        System.out.println("================================");

        sc.close();
    }
}