
import java.io.Serializable;

public class Student implements Serializable {

    private int id;
    private String name;
    private int grade;
    private String email;

    // Constructor
    public Student(int id, String name, int grade, String email) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.email = email;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGrade() {
        return grade;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Grade=" + grade + ", Email=" + email + "]";
    }
}
