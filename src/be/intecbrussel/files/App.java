package be.intecbrussel.files;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        Path destDir = Paths.get("C:/Data/folder1/");
        Path destFile = destDir.resolve("testing.txt");

        try {
            Files.createDirectories(destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            MyFileUtil.checkIfFileExistElseCreate(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            MyFileUtil.writeSomeLinesToFile(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stream<String> content = null;

        try {

            content = Files.lines(destFile);
            content.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            assert content != null;
            content.close();
        }



        try {
            Path temp = destDir.resolve("copyTesting.txt");
            if (Files.notExists(temp)) Files.copy(destFile, temp);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.deleteIfExists(destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
