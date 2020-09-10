package be.intecbrussel.test_move_files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class MoveFiles2 {

    public static void main(String[] args) {


        Path path = Paths.get("C:/Data");
        File pathFile = path.toFile();
        File[] files = pathFile.listFiles();
        Path pathAttributes = path.resolve("Attribute.txt");
        File attributeFile = new File(String.valueOf(pathAttributes));


        // Create map of extensions and list of files [jpg=[test1.jpg, test2.jpg], txt=[test.txt, test2.txt]]
        Map<String, List<File>> extFilesMap = createExtensionFileMap(files, attributeFile);

//        System.out.println(extFilesMap.entrySet());//TODO to delete, just to test code


        try (FileWriter fWriter = new FileWriter(attributeFile)) {

            for (Map.Entry entry : extFilesMap.entrySet()) {

                String ext = String.valueOf(entry.getKey());

                // create directory by extension and return the extension path
                Path extPath = createDirectoryByExtension(ext, path);

                // write to Attribute.txt the extension type
                fWriter.write("\n********************\n");
                fWriter.write(ext);
                fWriter.write("\n********************\n");

                // write to Attribute.txt the header of file attributes
                fWriter.write(String.format("%1$15s %2$15s %3$30s %n", "File name", "Owner", "Visibility"));

                for (File file : extFilesMap.get(ext)) {

                    // write attributes files to Attribute.txt
                    String hidden = file.isHidden() ? "hidden" : "visible";
                    fWriter.write(String.format("%1$-20s %2$20s %3$10s %n", file.getName(), Files.getOwner(file.toPath()), hidden));

                    // move files to the correct extension folder
                    try {
                        Files.move(file.toPath(), extPath.resolve(file.getName()), REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    // the attributeFile argument is the txt file where all the arguments are stored
    // this file does not needed to be moved
    private static Map<String, List<File>> createExtensionFileMap(File[] files, File attributeFile) {

        Map<String, List<File>> extFilesMap = new HashMap<>();
        String extension;


        for (File file : files) {

            String fileName = file.getName();
            int lastIndexOf = fileName.lastIndexOf(".");

            if (lastIndexOf >= 0 && !file.equals(attributeFile)) { //if no extension then it is a folder and ignore Attribute.txt file

                extension = fileName.substring(lastIndexOf + 1);

                if (!extFilesMap.containsKey(extension)) {

                    extFilesMap.put(extension, new ArrayList<>());
                }

                extFilesMap.get(extension).add(file);
            }

        }

        return extFilesMap;
    }

    private static Path createDirectoryByExtension(String extension, Path path) {

        Path extPath = path.resolve(extension);
        try {
            Files.createDirectories(extPath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return extPath;
    }

}

