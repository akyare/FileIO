package be.intecbrussel.object_serialization.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDateTime;

public class ReaderObjectApp {

    public static void main(String[] args) {

        try(FileInputStream file = new FileInputStream("MyFile.ser");
        ObjectInputStream in = new ObjectInputStream(file)) {

            System.out.println("Deserialize process has started.");

            String text = (String) in.readObject();
            LocalDateTime date = (LocalDateTime) in.readObject();

            System.out.println(text);
            System.out.printf("%td/%<tm/%<tY %<tH:%<tM:%<tS%n\n", date);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
