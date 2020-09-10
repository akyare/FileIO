package be.intecbrussel.io_Streams.character_streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderApp {

    public static void main(String[] args) {

        // Advice to read big chuncks to read and not character by character

        try (FileReader fileReader = new FileReader("MyTextFile.txt");
             BufferedReader reader = new BufferedReader(fileReader)){ // BufferedReader resource will be closed before the FileReader resource

            String line = null;

            while ((line = reader.readLine()) != null) {
//                if (line.trim().equals("")) {
//                    line = "\n\t\t\t*** Oooooh whitespaces***\n";
//                }
                System.out.println(line); // here we print a empyt line as it is not character by character reading
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Job is done.");
    }
}
