package main.java.com.homework.lesson12;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;


public class Task32 {

    //Task #32: write in file 20 random numbers; read this file,
    // print all numbers and their average.

    private String fileName;
    private int size;

    public Task32(String fileName, int size) {
        this.fileName = fileName;
        this.size = size;
    }

    public boolean createRandomDataFile() {
        DataOutputStream dataOutputStream = null;
        boolean result = true;
        try {
            dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)));
        } catch (FileNotFoundException e) {
            result = false;
        }
        int[] randomNumbers = createRandomNumbers();
        for (int i = 0; i < size; i++) {
            try {
                dataOutputStream.writeInt(randomNumbers[i]);
            } catch (IOException e) {
                result = false;
            }
        }
        try {
            dataOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private int[] createRandomNumbers() {
        return IntStream.generate(() -> (int) (Math.random() * 10 + 1)).limit(size).toArray();
    }

    public void printData() {
        for (int i : getData()) {
            System.out.print(i + ", ");
        }
    }

    public Integer getAverage() {
        return Arrays.stream(getData()).reduce(0, (a, b) -> (a + b) / 2);
    }

    private int[] getData() {
        int[] data = new int[size];
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));
        } catch (IOException e) {
            System.out.println("File" + fileName + " not found");
        }
        int i = 0;
        try {
            data[i] = dataInputStream.readInt();
            i++;
        } catch (IOException e) {
            System.out.println("Failed reading");
        }
        while (true) {
            try {
                data[i] = dataInputStream.readInt();
            } catch (IOException e) {
                break;
            }
            i++;
        }
        if (dataInputStream != null) {
            try {
                dataInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
