package edu.ti.filesandstreams.structured;

import edu.ti.filesandstreams.dataobject.Species;

import java.io.*;
import java.util.Scanner;

public class NewSpeciesFromCSV {
    public static void main(String[] args) {
        String resourceFolder = "src/main/resources";
        String speciesFileName = resourceFolder + "/" + "file.csv";
        String binaryFileName = resourceFolder + "/" + "file.dat";
        Scanner inputStream = null;
        try {
            File file = new File(speciesFileName);
            inputStream = new Scanner(file);
            String line = inputStream.nextLine();

            while (inputStream.hasNextLine()) {

                line = inputStream.nextLine();
                String[] dataArray = line.split(",");
                String name = dataArray[0];
                int population = Integer.parseInt(dataArray[1]);
                double growthRate = Double.parseDouble(dataArray[2]);

                Species[] initSpecies = {
                        new Species(name, population, growthRate)};


                try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(binaryFileName))) {
                    objectOutputStream.writeObject(initSpecies);
                } catch (FileNotFoundException e) {
                    System.out.println("FileNotFoundException thrown writing to file " + binaryFileName + ":" + e.getMessage());
                } catch (IOException e) {
                    System.out.println("IOException thrown writing to file " + binaryFileName + ":" + e.getMessage());
                }

                System.out.println("Array written to file " + binaryFileName + " and file is closed.");

            }
        } catch (IOException e) {
            System.out.println("Problem with input from file " + speciesFileName + ": " + e.getMessage());
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}

