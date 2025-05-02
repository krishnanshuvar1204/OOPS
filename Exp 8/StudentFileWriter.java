import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentFileWriter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Enter grade: ");
        String grade = scanner.next();

        String studentData = "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade + "\n";

        try (FileWriter writer = new FileWriter("student.txt", true)) 
        {
            writer.write(studentData);
            System.out.println("Student details successfully saved to student.txt.");
        } catch (IOException e) {
            System.out.println("Error occurred while writing to the file.");
        } finally {
            System.out.println("File operation attempted.");
        }

        scanner.close();
    }
}