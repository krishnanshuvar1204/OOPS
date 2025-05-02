import java.io.*;
import java.util.Scanner;

public class FileWordCharCounter {
    public static void main(String[] args) {
        String fileName = "sample.txt"; 
        createSampleFile(fileName);
        countWordsAndCharacters(fileName);
    }
    
    public static void createSampleFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Hello world\nJava is awesome!\n");
            System.out.println("Sample file '" + fileName + "' created successfully.");
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }

    public static void countWordsAndCharacters(String fileName) {
        File file = new File(fileName);

        if (!file.exists() || !file.isFile()) {
            System.out.println("File not found. Please enter a valid file name.");
            return;
        }

        int wordCount = 0;
        int charCount = 0;

        try (FileInputStream fis = new FileInputStream(file);
             Scanner fileScanner = new Scanner(fis)) {

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                wordCount += countWords(line);
                charCount += countCharacters(line);
            }

            System.out.println("Total words: " + wordCount);
            System.out.println("Total characters (excluding whitespace): " + charCount);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    
    public static int countWords(String line) {
        String[] words = line.trim().split("\\s+"); 
        return line.trim().isEmpty() ? 0 : words.length;
    }

    public static int countCharacters(String line) {
        return line.replaceAll("\\s", "").length();
    }
}