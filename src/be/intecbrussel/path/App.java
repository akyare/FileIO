package be.intecbrussel.path;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.File;

public class App {

    public static void main(String[] args) {

        // We start by making an instance of the Path interface
        Path p1 = Paths.get("C:\\data");
        p1 = Paths.get("C:/data"); // as Design factory helps we could use // or \
        Path p2 = p1.resolve("folder1");
        Path p3 = p2.resolve("testing.txt");

        Path p4 = p1.resolve("testing.txt")
                .resolve("zekergeenwachtwoord.txt");

        Path pwd = Paths.get("C:\\Users\\akyar\\IdeaProjects\\file-io-student\\file-io-student.iml");

        // if we want to get a relative path
        Path p5 = p3.relativize(p1);

        Path relativeToRoot = Paths.get("C:\\").relativize(pwd);
        System.out.println(relativeToRoot);

        isAbsolute(p1);
        isAbsolute(p2);
        isAbsolute(p3);
        isAbsolute(p4);
        isAbsolute(p5);

        System.out.println("The root is: " + p3.getRoot());
        System.out.println("Filename: " + p3.getFileName());
        System.out.println("Get parent path: " + p3.getParent());

        System.out.println("\nOw boiiii; we have the foreach method\n");

        p3.forEach(System.out::println);

        Path realPathP3 = toRealPath(p3);
        Path realPathP4 = toRealPath(p4);

        File file = p3.toFile();

//        try {
//
//        } catch (IOException e) {
//
//        }

    }

    private static void isAbsolute(Path p) {
        System.out.println(p.toAbsolutePath() + " is an absolute path "
                + p.isAbsolute());
    }

    private static Path toRealPath(Path p) {

        Path temp = null;

        try {

             temp = p.toRealPath();
        } catch (IOException e) {
            // TODO: find something useful to do
            e.printStackTrace();
        }

        return temp;
    }
}
