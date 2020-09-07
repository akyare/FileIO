package be.intecbrussel.path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class App2 {

    public static void main(String[] args) {

        Path p1 = Paths.get("C:/data/file.txt");
        Path p2 = Paths.get("C:/data/copyfile.txt");

        Path p3 = p1.getFileName();
        System.out.println(p3);


        System.out.println("Compare: " + p1.compareTo(p2));

        for (Path path : p1) {
            System.out.println(path);
        }

        p2.forEach(System.out::println);

        System.out.println("This file is a .txt file: " + p1.endsWith(Paths.get("file.txt"))); //with object Paths
        System.out.println("This file is located under the C drive: " + p1.startsWith("C:/")); //with s

    }
}
