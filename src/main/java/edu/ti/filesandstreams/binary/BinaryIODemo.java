package edu.ti.filesandstreams.binary;

import edu.ti.filesandstreams.dataobject.Species;

import java.io.*;

public class BinaryIODemo {
    //TODO -- read species data from an input file
    static Species[] initSpecies = {
            new Species ("Calif. Condor", 27, 0.02),
            new Species ("Black Rhino", 100, 1.0)
    };

    public static void main (String [] args) {
        //TODO -- get the fileName from a command line argument
        String resourceFolder = "src/main/resources";
        String fileName = resourceFolder + "/" + "species.dat";
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream (new FileOutputStream(fileName))){
            objectOutputStream.writeObject (initSpecies);
        } catch (FileNotFoundException e) {
            System.out.println ("FileNotFoundException thrown writing to file " + fileName + ":" + e.getMessage());
        } catch (IOException e) {
            System.out.println ("IOException thrown writing to file " + fileName + ":" + e.getMessage());
        }
        System.out.println ("Array written to file " + fileName + " and file is closed.");
        System.out.println ("Open the file for input and echo the array.");

        Species[] readFromFileSpecies = null;
        try (ObjectInputStream inputStream =
                new ObjectInputStream (
                    new FileInputStream(fileName))) {
            readFromFileSpecies = (Species[]) inputStream.readObject ();
        } catch (Exception e) {
            System.out.println ("Error reading file " + fileName + ": " + e.getMessage());
        }

        System.out.println("The following were read from the file " + fileName + ":");
        assert readFromFileSpecies != null;
        for (Species readFromFileSpecy : readFromFileSpecies) {
            System.out.println(readFromFileSpecy.toString());
        }
    }
}
