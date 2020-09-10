package be.intecbrussel.test_move_files;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

public class MoveFiles {

    public static void main(String[] args) {


        Path path = Paths.get("C:/Data");
        File pathFile = path.toFile();

        File[] files = pathFile.listFiles();

        Map<String, List<File>> extFilesMap = new HashMap<>();
        Path pathAttributes = path.resolve("Attribute.txt");

        // Create map of extensions and list of files [jpg=[test1.jpg, test2.jpg], txt=[test.txt, test2.txt]]
        for (File file : files) {


            String fileName = file.getName();
            int lastIndexOf = fileName.lastIndexOf(".");
            String extension;

            if (lastIndexOf >= 0 && !file.equals(pathAttributes.toFile())) { //if no extension then it is a folder and ignore Attribute.txt file

                extension = fileName.substring(lastIndexOf + 1);

                if(!extFilesMap.containsKey(extension)) {

                        extFilesMap.put(extension, new ArrayList<>());
                }

                extFilesMap.get(extension).add(file);
            }

        }
        System.out.println(extFilesMap.entrySet());


        try (FileWriter fWriter = new FileWriter(String.valueOf(pathAttributes))) {

            for (String ext : extFilesMap.keySet()) {

                Path extPath = path.resolve(ext);

                // create directory by extension
                try {
                    Files.createDirectories(extPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                if (Files.notExists(pathAttributes)) {
                    try {
                        Files.createFile(pathAttributes); // file will contain all the attributes by file
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


                // write attributes files to Attribute.txt and move files to the correct extension folder
                fWriter.write("\n********************\n");
                fWriter.write(ext);
                fWriter.write("\n********************\n");

                fWriter.write(String.format("%1$15s %2$15s %3$30s %n", "File name", "Owner", "Visibility"));

                for (File file : extFilesMap.get(ext)) {
                    String hidden = file.isHidden() ? "hidden" : "visible";

                    fWriter.write(String.format("%1$-20s %2$20s %3$10s %n", file.getName(), Files.getOwner(file.toPath()), hidden));


                    try {
                        Files.move(file.toPath(), extPath.resolve(file.getName()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
