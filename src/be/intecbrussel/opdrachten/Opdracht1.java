package be.intecbrussel.opdrachten;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.DosFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Opdracht1 {

    public static void main(String[] args) {

        Path destDir = Paths.get("C:/Data");
        Path destFile = destDir.resolve("test.txt");
        List<String> content = new ArrayList<>();
        content.add("Some Lines");
        content.add(" are added.");

        try {
            Files.createDirectories(destDir);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (Files.notExists(destFile)) {
                Files.createFile(destFile);
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.write(destFile,
                    content,
                    Charset.defaultCharset(),
                    StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        DosFileAttributes attributes = null;
        try {
            attributes = Files.readAttributes(destDir, DosFileAttributes.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Hidden: " + attributes.isHidden());
        System.out.println("Archived: " + attributes.isArchive());
        System.out.println("Read only: " + attributes.isReadOnly());
        System.out.println("System: " + attributes.isSystem());
        System.out.println("Creation Time: " + attributes.creationTime());
        System.out.println("Directory: " + attributes.isDirectory());
        System.out.println("Regular file: " + attributes.isRegularFile());


//        Stream<String> lines = null;
//
//        try {
//            lines = Files.lines(destFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        assert lines != null;
//        lines.forEach(System.out::println);
//        lines.close();

        //Same as above in comments , auto close resources
        //lines2 is only for example, we can auto close multiple resources
        try (Stream<String> lines = Files.lines(destFile);
             Stream<String> lines2 = Files.lines(destFile)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Owner of test.txt: " + Files.getOwner(destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            Files.move(destFile,destFile.resolveSibling("test2.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
