package SelfLearn3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileHandling {

    public static void main(String[] args) {
        String fileName = "example.txt";
        
        // Write to file
        writeToFile(fileName, "Hello, World!");
        
        // Read from file
        String content = readFromFile(fileName);
        System.out.println("File content: " + content);
        
        // Append to file
        appendToFile(fileName, "This is an appended line.");
        
        // Read again to verify the appended content
        content = readFromFile(fileName);
        System.out.println("File content after appending: " + content);
    }
    
    // Method to write content to a file
    public static void writeToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
            System.out.println("Successfully wrote to the file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
    }
    
    // Method to read content from a file
    public static String readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
        return content.toString();
    }
    
    // Method to append content to a file
    public static void appendToFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(content);
            System.out.println("Successfully appended to the file: " + fileName);
        } catch (IOException e) {
            System.err.println("Error appending to the file: " + e.getMessage());
        }
    }
}
