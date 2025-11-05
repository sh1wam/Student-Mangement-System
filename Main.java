
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n --- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("Enter your Choice (1-5): ");

            int choice = 0;

            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent(scanner, sms);
                    break;
                case 2:
                    sms.viewStudents();
                    break;
                case 3:
                    updateStudent(scanner, sms);
                    break;
                case 4:
                    deleteStudent(scanner, sms);
                    break;
                case 5:
                    System.out.println("Exiting application");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice, please enter number between 1-5");
            }
        }
    }

    private static void addStudent(Scanner scanner, StudentManagementSystem sms) {
        try {
            System.out.println("Enter student id: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter Student name: ");
            String name = scanner.nextLine();
            System.out.println("Enter Student grade: ");
            int grade = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter student email: ");
            String email = scanner.nextLine();

            if (sms.findStudentById(id) != null) {
                System.out.println("Error, student with id " + id + " already exists");
            } else {
                Student newStudent = new Student(id, name, grade, email);
                sms.addStudent(newStudent);
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type, try again");
            scanner.nextLine();
        }
    }

    private static void updateStudent(Scanner scanner, StudentManagementSystem sms) {
        try {
            System.out.println("Enter student id to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            if (sms.findStudentById(id) == null) {
                System.out.println("Student with id " + id + " not found");
                return;
            }

            System.out.println("Enter new name: ");
            String newName = scanner.nextLine();
            System.out.println("Enter new grade: ");
            int newGrade = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter new email: ");
            String newEmail = scanner.nextLine();

            sms.updateStudent(id, newName, newGrade, newEmail);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type, try again");
            scanner.nextLine();
        }
    }

    private static void deleteStudent(Scanner scanner, StudentManagementSystem sms) {
        try {
            System.out.println("Enter student id to delete: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            sms.deleteStudent(id);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input, try again");
            scanner.nextLine();
        }
    }
}
