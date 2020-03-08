package edu.ti.filesandstreams.structured;

import edu.ti.filesandstreams.dataobject.Species;

import java.io.*;
import java.util.Scanner;

public class ReadBinaryWriteFile {
    static Species[] initSpecies = {
            new Species("Calif. Condor", 27, 0.02),
            new Species("Black Rhino", 100, 1.0)
    };

    public static void main(String[] args) throws IOException {

        String resourceFolder = "src/main/resources";
        String fileName = resourceFolder + "/" + "species.dat";
        String textFileName = resourceFolder + "/" + "species.txt";
        Species[] readFromFileSpecies = null;
        Scanner outputStream = null;

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(initSpecies);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException thrown writing to file " + fileName + ":" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException thrown writing to file " + fileName + ":" + e.getMessage());
        }

        try (
                ObjectInputStream inputStream =
                        new ObjectInputStream(
                                new FileInputStream(fileName))) {

            readFromFileSpecies = (Species[]) inputStream.readObject();
            
        } catch (Exception e) {
            System.out.println("Error reading file " + fileName + ": " + e.getMessage());
        }

        FileWriter file = new FileWriter(textFileName);
        file.write(String.valueOf(readFromFileSpecies));
        file.close();

        System.out.println("Species writen to file " + textFileName + ".");
    }
}
