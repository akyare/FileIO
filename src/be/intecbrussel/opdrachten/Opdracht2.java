package be.intecbrussel.opdrachten;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Opdracht2 {

    public static void main(String[] args) {

        Path path =  Paths.get("C:/Data/test.txt");
        File file = path.toFile();

        try (FileWriter fWriter = new FileWriter(file)) {
            fWriter.write("A few lines.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
