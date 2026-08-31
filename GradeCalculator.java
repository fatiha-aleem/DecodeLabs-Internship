import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of subjects: ");
        int numSubjects = Integer.parseInt(sc.nextLine().trim());

        int totalMarks = 0;

        for (int i = 1; i <= numSubjects; i++) {
            int mark;

            while (true) {
                System.out.print("Enter marks for subject " + i + " (0-100): ");
                mark = Integer.parseInt(sc.nextLine().trim());

                if (mark < 0 || mark > 100) {
                    System.out.println("Invalid input! Marks must be between 0 and 100.");
                } else {
                    break;
                }
            }

            totalMarks += mark;
        }

        double average = (double) totalMarks / numSubjects;

        char grade;

        if (average >= 90) {
            grade = 'A';
        } else if (average >= 80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("\n--- Student Report ---");
        System.out.printf("Total Marks: %d/%d%n", totalMarks, numSubjects * 100);
        System.out.printf("Average: %.2f%%%n", average);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}