
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem {

    private List<Student> students;
    private String filename = "students.dat";

    // Constructor
    public StudentManagementSystem() {
        this.students = new ArrayList<>();
        loadStudentsFromFile();
    }

    // Create
    public void addStudent(Student student) {
        students.add(student);
        saveStudentsToFile();
        System.out.println("Student added successfully");
    }

    // Read and view
    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the system");
            return;
        }
        System.out.println("List of all students: ");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // Find Student by ID
    public Student findStudentById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    // Update
    public void updateStudent(int id, String newName, int newGrade, String newEmail) {
        Student studentToUpdate = findStudentById(id);
        if (studentToUpdate != null) {
            studentToUpdate.setName(newName);
            studentToUpdate.setGrade(newGrade);
            studentToUpdate.setEmail(newEmail);
            saveStudentsToFile();
            System.out.println("Students details Successfully updated");
        } else {
            System.out.println("student with id: " + id + " not found");
        }
    }

    // Delete
    public void deleteStudent(int id) {
        Student studentToDelete = findStudentById(id);
        if (studentToDelete != null) {
            students.remove(studentToDelete);
            saveStudentsToFile();
            System.out.println("Student with id " + id + " deleted successfully");
        } else {
            System.out.println("student with id: " + id + " not found");
        }
    }

    // File Handling Saving to file
    @SuppressWarnings("unchecked")
    private void saveStudentsToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.out.println("Error saving students to file: " + e.getMessage());
        }
    }

    // File Handling Load
    @SuppressWarnings("unchecked")
    private void loadStudentsFromFile() {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("Data file not found. Start with new list");
            return;
        }

        if (file.length() == 0) {
            System.out.println("Data file is empty. Starting with new list");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            this.students = (ArrayList<Student>) ois.readObject();
            System.out.println("Loaded " + students.size() + " students from" + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading students from file: " + e.getMessage());
            this.students = new ArrayList<>();
        }
    }
}
