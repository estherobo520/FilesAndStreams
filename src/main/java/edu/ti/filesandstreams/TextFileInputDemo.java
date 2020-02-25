package edu.ti.filesandstreams;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TextFileInputDemo {
    public static void main(String[] args) {
        String fileName = "out.txt";
        Scanner inputStream = null;
        System.out.println("The file " + fileName +
                "\ncontains the following lines:\n");
        try {
            File file = new File(fileName);
            inputStream = new Scanner(file);
            while (inputStream.hasNextLine()) {
                String line = inputStream.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + fileName);
            //System.exit(0);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}