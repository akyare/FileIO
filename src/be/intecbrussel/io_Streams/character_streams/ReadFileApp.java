package be.intecbrussel.io_Streams.character_streams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileApp {

    public static void main(String[] args) {

        try (FileReader fReader = new FileReader("MyTextFile.txt")) {

            int character;

            while ((character = fReader.read()) != -1) { // -1 if the end of the file has been reached
                System.out.print((char) character);
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
