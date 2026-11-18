import java.util.Scanner;

/**
 * Task 2: Student Grade Calculator
 *
 * Steps:
 * 1. Input: marks obtained (out of 100) in each subject
 * 2. Calculate total marks
 * 3. Calculate average percentage
 * 4. Assign a grade based on the average percentage
 * 5. Display total marks, average percentage and grade
 */
public class GradeCalculator {

    // Keep asking until the user enters a valid mark between 0 and 100
    static double getMarks(Scanner sc, int subjectNumber) {
        while (true) {
            System.out.print("Enter marks for subject " + subjectNumber + " (out of 100): ");
            if (sc.hasNextDouble()) {
                double marks = sc.nextDouble();
                if (marks >= 0 && marks <= 100) {
                    return marks;
                }
                System.out.println("  Marks must be between 0 and 100. Try again.");
            } else {
                System.out.println("  Please enter a valid number.");
                sc.next(); // discard bad input
            }
        }
    }

    // Return a grade for the given average percentage
    static String calculateGrade(double average) {
        if (average >= 90) return "A+";
        else if (average >= 80) return "A";
        else if (average >= 70) return "B";
        else if (average >= 60) return "C";
        else if (average >= 50) return "D";
        else if (average >= 40) return "E";
        else return "F (Fail)";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== STUDENT GRADE CALCULATOR ===\n");

        // Input: number of subjects
        int numSubjects;
        while (true) {
            System.out.print("Enter the number of subjects: ");
            if (sc.hasNextInt()) {
                numSubjects = sc.nextInt();
                if (numSubjects > 0) break;
                System.out.println("  Number of subjects must be at least 1.");
            } else {
                System.out.println("  Please enter a whole number.");
                sc.next();
            }
        }

        // Input: marks for each subject, and total marks
        double totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++) {
            totalMarks += getMarks(sc, i);
        }

        // Average percentage and grade
        double averagePercentage = totalMarks / numSubjects;
        String grade = calculateGrade(averagePercentage);

        // Display results
        System.out.println("\n--------- RESULT ---------");
        System.out.printf("Total Marks        : %.0f / %d%n", totalMarks, numSubjects * 100);
        System.out.printf("Average Percentage : %.2f%%%n", averagePercentage);
        System.out.println("Grade              : " + grade);
        System.out.println("--------------------------");

        sc.close();
    }
}