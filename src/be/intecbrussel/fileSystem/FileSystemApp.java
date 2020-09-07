package be.intecbrussel.fileSystem;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.attribute.UserPrincipalLookupService;

public class FileSystemApp {

    public static void main(String[] args) {

        final String NEW_LINE = "\n";

        // Thanks to the factory design principle we can ask for the correct filesystem
        FileSystem fSystem = FileSystems.getDefault();

        System.out.println("Separated by: " + fSystem.getSeparator() + NEW_LINE);

        // What our the root directories
        fSystem.getRootDirectories()
                .forEach(System.out::println);

        System.out.println(NEW_LINE + "System is read only: " + fSystem.isReadOnly() + NEW_LINE);

        System.out.println("Access levels on root: " + NEW_LINE);

        fSystem.supportedFileAttributeViews()
                .forEach(System.out::println);

        UserPrincipalLookupService userLookup = fSystem.getUserPrincipalLookupService();

        try {
            System.out.println("Check out this user: " + userLookup.lookupPrincipalByGroupName("ABDEL K"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
