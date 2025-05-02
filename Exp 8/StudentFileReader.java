import java.io.File;
import java.io.FileReader;
import java.io.IOException; 
public class StudentFileReader {
    public static void main(String[] args) {
        File file = new File("student.txt");

        try (FileReader reader = new FileReader(file))
        {
            int character;
            System.out.println("Contents of student.txt:");
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }

        } catch (IOException e)
        {
            System.out.println("Error: File not found or could not be read.");
        } finally {
            System.out.println("\nFile operation attempted.");
        }
    }
}