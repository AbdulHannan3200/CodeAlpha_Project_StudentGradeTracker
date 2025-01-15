import java.util.Scanner;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner uInput = new Scanner(System.in);

        int numStudents = 3; // Number of students
        int numSubjects = 3; // Number of subjects
        int[][] grades = new int[numStudents][numSubjects];

        double[] studentAverages = new double[numStudents]; // To store the average marks of each student

        // Input grades for each student
        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter marks for student " + (i + 1) + ":");
            int sum = 0;
            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Subject " + (j + 1) + ": ");

                // Validate input
                while (!uInput.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a valid integer.");
                    uInput.next(); // Clear the invalid input
                }
                grades[i][j] = uInput.nextInt();
                sum += grades[i][j]; // Add to the total sum for this student
            }
            // Calculate average for the student
            studentAverages[i] = (double) sum / numSubjects;
        }

        // Calculate class-level results
        double highestAverage = Double.MIN_VALUE;
        double lowestAverage = Double.MAX_VALUE;
        double totalClassAverage = 0.0;

        int highestStudent = -1; // To store the index of the highest-scoring student
        int lowestStudent = -1;  // To store the index of the lowest-scoring student

        for (int i = 0; i < numStudents; i++) {
            totalClassAverage += studentAverages[i];

            if (studentAverages[i] > highestAverage) {
                highestAverage = studentAverages[i];
                highestStudent = i;
            }

            if (studentAverages[i] < lowestAverage) {
                lowestAverage = studentAverages[i];
                lowestStudent = i;
            }
        }

        // Final class average
        totalClassAverage /= numStudents;

        // Display results
        System.out.println("\nClass Results:");
        System.out.println("Highest scoring student: Student " + (highestStudent + 1) + " with an average of " + highestAverage);
        System.out.println("Lowest scoring student: Student " + (lowestStudent + 1) + " with an average of " + lowestAverage);
        System.out.println("Class average score: " + totalClassAverage);

        uInput.close();
    }
}
