package main.java.com.homework.lesson12;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task32 {

    public static void main(String[] args) {
        Task32 testData = new Task32("task32.txt", 20);
        if (testData.createRandomDataFile()) {
            System.out.println("Data: " + testData.getData());
            //System.out.println("Average: " + testData.getAverage());
        }
    }

    private String fileName;
    private int size;

    public Task32(String fileName, int size) {
        this.fileName = fileName;
        this.size = size;
    }

    public boolean createRandomDataFile() {
        try (DataInputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName))) {
            Integer[] randomData = (Integer[]) Stream.generate(() -> ((int) (Math.random() * 10) + 1))
                    .limit(size)
                    .toArray();
            for(Integer i: randomData){
                dataOutputStream.writeInt(randomData[i]);
            }
        } catch(FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
        return true;
    }


    public Integer[] getData() {
        Integer[] data = new Integer[size];
        try {
            data = (Integer[]) Files.lines(Paths.get(fileName))
                    .map(Integer::parseInt)
                    .toArray();
        } catch (IOException e) {
            System.out.println("File" + fileName + " not found");
        }
        return data;
    }

    public Integer getAverage() {
        return Arrays.stream(getData()).reduce(0, (a, b) -> (a + b) / 2);
    }
}