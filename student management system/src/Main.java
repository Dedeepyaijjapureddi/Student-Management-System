import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter student id: ");
                    int id = sc.nextInt();
                    boolean idExists = false;

                    for (int i = 0; i < students.size(); i++) {
                        Student s = students.get(i);

                        if (s.getId() == id) {
                            idExists = true;
                            break;
                        }
                    }

                    if (idExists) {
                        System.out.println("Student ID already exists");
                        break;
                    }
                    System.out.print("Enter student age: ");

                    int age;

                    try {
                        age = sc.nextInt();
                    } catch (java.util.InputMismatchException e) {
                        System.out.println("Invalid age. Enter numbers only.");
                        sc.nextLine();
                        break;
                    }
                    if (age <= 0 || age > 100) {
                        System.out.println("Invalid age");
                        break;
                    }
                    System.out.print("Enter student name: ");
                    String name = sc.next();
                    if (name.matches("[0-9]+")) {
                        System.out.println("Invalid name");
                        break;
                    }
                    Student newStudent = new Student(id, age, name);
                    students.add(newStudent);

                    System.out.println("Student added successfully");
                    break;

                case 2:
                    if (students.size() == 0) {
                        System.out.println("No students found");
                    } else {
                        System.out.println("Students:");
                        System.out.println("Total Students: " + students.size());
                        for (int i = 0; i < students.size(); i++) {
                            Student s = students.get(i);
                            System.out.println(s.getId() + " " + s.getAge() + " " + s.getName());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (int i = 0; i < students.size(); i++) {
                        Student s = students.get(i);

                        if (s.getId() == searchId) {
                            System.out.println("Student found:");
                            System.out.println(s.getId() + " " + s.getName() + " " + s.getAge());
                            found = true;
                            break;
                        }
                    }

                    if (found == false) {
                        System.out.println("Student not found");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID to update: ");
                    int updateId = sc.nextInt();

                    boolean updateFound = false;

                    for (int i = 0; i < students.size(); i++) {
                        Student s = students.get(i);

                        if (s.getId() == updateId) {
                            System.out.print("Enter new age: ");
                            int newAge = sc.nextInt();

                            if (newAge <= 0 || newAge > 100) {
                                System.out.println("Invalid age");
                                break;
                            }

                            s.setAge(newAge);

                            System.out.println("Student updated successfully");
                            updateFound = true;
                            break;
                        }
                    }

                    if (updateFound == false) {
                        System.out.println("Student not found");
                    }
                    break;

                case 5:
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = sc.nextInt();

                    boolean deleteFound = false;

                    for (int i = 0; i < students.size(); i++) {
                        Student s = students.get(i);

                        if (s.getId() == deleteId) {
                            students.remove(i);

                            System.out.println("Student deleted successfully");
                            deleteFound = true;
                            break;
                        }
                    }

                    if (deleteFound == false) {
                        System.out.println("Student not found");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}