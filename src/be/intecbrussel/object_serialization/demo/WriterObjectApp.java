package be.intecbrussel.object_serialization.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class WriterObjectApp {

    public static void main(String[] args) {

        String text = "This is some text";
        LocalDateTime today = LocalDateTime.now();

        try (FileOutputStream file = new FileOutputStream("MyFile.ser");
             ObjectOutputStream out = new ObjectOutputStream(file)) { // .ser is a convention, we can provide anything we want

            out.writeObject(text);
            out.writeObject(today);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("\nObjects are serialized.\nProgram finished...");
        }

    }

}
