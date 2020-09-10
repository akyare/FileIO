package be.intecbrussel.io_Streams.character_streams;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteFileApp {

    public static void main(String[] args) {



        // Without try(resources)
        // MyTextFile.txt is created on the root of the project
//        FileWriter fWriter = null;
//        try {
//            fWriter = new FileWriter("MyTextFile.txt");
//
//            fWriter.write("Hello");
//            fWriter.write("World!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//
//            try {
//                if (fWriter != null) {
//                    fWriter.close();
//                }
//            } catch (IOException io) {
//                System.out.println("Error closing a file writer");
//            }
//            System.out.println("Job done, no problem sir!");
//        }

        // With try(resources)
        try (FileWriter fWriter = new FileWriter("MyTextFile.txt");
        FileWriter fileWriter = new FileWriter("SecondFile.txt")) {
            fWriter.write("Hello");
            fWriter.write("World!");

            fileWriter.write("This is also closed after the try with resources.");
        } catch (IOException e) {
            e.printStackTrace();
        }


        // With File in place of string as argument for new FileWriter()
        Path pathTotallyNotNeededAttAll =  Paths.get("MyTextFile2.txt");
        File file = pathTotallyNotNeededAttAll.toFile();
        try (FileWriter fWriter = new FileWriter(file)) {
            fWriter.write("Hello");
            fWriter.write("World!");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
