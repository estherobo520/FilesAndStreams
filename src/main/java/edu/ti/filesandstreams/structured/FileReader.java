package edu.ti.filesandstreams.structured;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileReader {
    public static void main(String[] args) {
        String resourceFolder = "src/main/resources";
        String rawFile = "file.txt";
        String fileName = resourceFolder + "/" + rawFile;
        Scanner inputStream = null;

        try {
            File file = new File(fileName);
            inputStream = new Scanner(file);
            String line = inputStream.nextLine();

            int totalLines = 0;
            int totalWords = 0;
            while (inputStream.hasNextLine()) {

                line = inputStream.nextLine();
                totalLines+=1;
                String[] dataArray = line.split(",");
                totalWords += dataArray.length;
            }
            totalLines += 1;
            System.out.printf("Total lines: " + totalLines + ", total words: " + totalWords + " in file: " + rawFile +".");
        } catch (IOException e) {
            System.out.println("Problem with input from file " + rawFile + ": " + e.getMessage());
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}