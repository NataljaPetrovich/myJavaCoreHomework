package main.java.com.homework.lesson12;

import java.io.*;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * The type data file with 20 random numbers.
 */
public class RandomDataFile {
    /**
     * The File name.
     */
    String fileName;

    /**
     * Instantiates a new file with 20 random numbers.
     *
     * @param fileName the file name
     */
    public RandomDataFile(String fileName) {
        this.fileName = fileName;
        DataOutputStream dataOutputStream;
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return;
        }
        Stream.generate(() -> ((int) (Math.random() * 10) + 1))
                .limit(20)
                .forEach(n -> {
                    try {
                        dataOutputStream.writeInt(n);
                    } catch (IOException e) {
                        System.out.println("Problem with data to file writing");
                    }
                });
        try {
            dataOutputStream.close();
        } catch (IOException e) {
            System.out.println("Problem with closing DataOutputStream");
        }
    }

    /**
     * Show content of the file.
     */
    public void showContent() {
        createStream().forEach(System.out::println);
    }

    /**
     * Show average of all numbers in the file.
     */
    public void showAverage() {
        System.out.println("Average: " + createStream().average());
    }

    /**
     * Creates IntStream of all numbers in the file.
     */
    private IntStream createStream() {
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        DataInputStream finalDin = dataInputStream;
        return IntStream.generate(() -> {
            try {
                assert finalDin != null;
                return finalDin.readInt();
            } catch (IOException e) {
                System.out.println("Stream problem");
            }
            return 0;
        })
                .limit(20);
    }

}
