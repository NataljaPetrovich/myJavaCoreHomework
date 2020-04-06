package main.java.com.homework.lesson13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;


/**
 * The type Task 33.
 * List files and directories of chosen directory.
 * Files & directories should be printed separately.
 */
public class Task33 {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        Task33 test = new Task33();
        test.showDirectories(".\\out\\production\\myJavaCoreHomework");
        test.showFiles(".\\out\\production\\myJavaCoreHomework");
    }

    /**
     * Show files.
     *
     * @param yourDirectory the your directory
     */
    public void showFiles(String yourDirectory) {
        try {
            System.out.println(Files.walk(Paths.get(yourDirectory))
                    .filter(Files::isRegularFile)
                    .map(f -> f.getFileName())
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }


    /**
     * Show directories.
     *
     * @param yourDirectory the your directory
     */
    public void showDirectories(String yourDirectory) {
        try {
            System.out.println(Files.walk(Paths.get(yourDirectory))
                    .filter(Files::isDirectory)
                    .collect(Collectors.toList()));
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
}


