import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private double feesPaid;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.feesPaid = 0;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public double getFeesPaid() {
        return feesPaid;
    }

    public void makePayment(double amount) {
        feesPaid += amount;
    }

    public double calculateRemainingFees(double totalFees) {
        return totalFees - feesPaid;
    }
}

class FeesManagementSystem {
    private ArrayList<Student> students;

    public FeesManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudentDetails() {
        System.out.println("Student Details:");
        for (Student student : students) {
            System.out.println("ID: " + student.getStudentId() + ", Name: " + student.getName()
                    + ", Fees Paid: " + student.getFeesPaid());
        }
    }

    public void processPayment(String studentId, double amount) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                student.makePayment(amount);
                System.out.println("Payment of $" + amount + " processed for student ID: " + studentId);
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }

    public void displayRemainingFees(String studentId, double totalFees) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                double remainingFees = student.calculateRemainingFees(totalFees);
                System.out.println("Remaining Fees for student ID " + studentId + ": $" + remainingFees);
                return;
            }
        }
        System.out.println("Student with ID " + studentId + " not found.");
    }
}

class fees {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FeesManagementSystem feesManagementSystem = new FeesManagementSystem();

        // Adding sample students
        feesManagementSystem.addStudent(new Student("S001", "John Doe"));
        feesManagementSystem.addStudent(new Student("S002", "Jane Doe"));

        while (true) {
            System.out.println("\n1. Display Student Details");
            System.out.println("2. Process Payment");
            System.out.println("3. Display Remaining Fees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    feesManagementSystem.displayStudentDetails();
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    String paymentStudentId = scanner.next();
                    System.out.print("Enter payment amount: $");
                    double paymentAmount = scanner.nextDouble();
                    feesManagementSystem.processPayment(paymentStudentId, paymentAmount);
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    String remainingFeesStudentId = scanner.next();
                    System.out.print("Enter total fees: $");
                    double totalFees = scanner.nextDouble();
                    feesManagementSystem.displayRemainingFees(remainingFeesStudentId, totalFees);
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
