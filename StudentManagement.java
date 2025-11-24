import java.util.*;

class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println("Name: " + name + ", Marks: " + marks);
    }
}

public class StudentManagement {

    // method to safely take an integer input
    public static int safeIntInput(Scanner sc, String message) {
        int num;
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                break;
            } else {
                System.out.println("Invalid input! Please enter a number.");
                sc.next(); // clear invalid input
            }
        }
        return num;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            ArrayList<Student> students = new ArrayList<>();

            int n = safeIntInput(sc, "Enter number of students: ");

            for (int i = 0; i < n; i++) {
                System.out.print("Enter student name: ");
                String name = sc.next();

                int marks = safeIntInput(sc, "Enter marks: ");

                students.add(new Student(name, marks));
            }

            System.out.println("\n--- Student Details ---");
            for (Student s : students) {
                s.display();
            }
        }
    }
}
