import java.util.*;
public class task2 {
    private ArrayList<Integer> marks;
    private Scanner scanner;
    
    public task2() {
        marks = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void inputMarks() {
        System.out.println("Enter the number of subjects:");
        int numSubjects = scanner.nextInt();
        
        for (int i = 1; i <= numSubjects; i++) {
            System.out.println("Enter marks for subject " + i + " (out of 100):");
            int mark = scanner.nextInt();
            if (mark >= 0 && mark <= 100) {
                marks.add(mark);
            } else {
                System.out.println("Invalid marks. Please enter between 0 and 100.");
                i--;
            }
        }
    }
    
    public int calculateTotalMarks() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }
    
    public double calculateAveragePercentage() {
        return (double) calculateTotalMarks() / marks.size();
    }
    
    public char calculateGrade(double percentage) {
        if (percentage >= 90) return 'A';
        if (percentage >= 80) return 'B';
        if (percentage >= 70) return 'C';
        if (percentage >= 60) return 'D';
        return 'F';
    }
    
    public void displayResults() {
        int totalMarks = calculateTotalMarks();
        double averagePercentage = calculateAveragePercentage();
        char grade = calculateGrade(averagePercentage);
        
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
    }
    
    public static void main(String[] args) {
        task2 calculator = new task2();
        calculator.inputMarks();
        calculator.displayResults();
    }
}
