import java.io.*;

class Students implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String name;
    double gpa;

    public Students(int _id, String _name, double _gpa) {
        id = _id;
        name = _name;
        gpa = _gpa;
    }

    public void display() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("GPA: " + gpa);
    }
}

public class Exp5_MediumProblem {
    public static void main(String[] args) {
        Students student = new Students(13680, "Abhishek", 8.3);
        String filename = "student.ser";

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(student);
            System.out.println("Student object has been serialized.");
        } catch (IOException e) {
            System.err.println("Error during serialization: " + e.getMessage());
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Students deserializedStudent = (Students) ois.readObject();
            System.out.println("Student object has been deserialized.");
            deserializedStudent.display();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error during deserialization: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
        }
    }
}
