package be.intecbrussel.files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class MyFileUtil {

    private MyFileUtil() {

    }

    public static void writeSomeLinesToFile(Path path) throws IOException {

        if (path != null) {
            List<String> content = new ArrayList<>();
            content.add("Hello");
            content.add("World");
            content.add("!");

            Files.write(path,
                    content,
                    Charset.defaultCharset(),
                    StandardOpenOption.CREATE);

        }

    }

    public static void checkIfFileExistElseCreate(Path path) throws IOException {
        if (Files.notExists(path)) {
            Files.createFile(path);
            System.out.println("File is created!");
        } else {
            System.out.println("File already exists.");
        }
    }


}
