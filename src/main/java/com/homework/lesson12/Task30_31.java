package main.java.com.homework.lesson12;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task30_31 {

    //Task 30: Create text file, read it, count punctuation marks and words amount in the text.
    //Task 31: You have text file, which contains numbers. Find all numbers, print them, count sum,
    // delete all repeating numbers and print remaining.

    public static void mai(String[] args) {
        String fileName = "task30_31";
        String text = "This is7 ... a test text. It 7contains 10 10 punctuation marks! An7d words: 11, 11? ;0)";
        Task30_31 test = new Task30_31(fileName, text);
        if (test.createTextFile()) {
            System.out.println("Number of punctuation marks in the text: " + test.countPunctuationMarks());
            System.out.println("Number of words in the text: " + test.countWords());
            System.out.println("All numbers in the text: " + test.getAllNumbers());
            System.out.println("Sum of numbers in the text: " + test.sumNumbers());
            System.out.println("Unique numbers in the text: " + test.getUniqueNumbers());
        }
    }

    private String fileName;
    private String text;

    public Task30_31(String fileName, String text) {
        this.fileName = fileName;
        this.text = text;
    }

    public boolean createTextFile() {
        try (PrintWriter writer = new PrintWriter(fileName)) {
            writer.print(text);
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return false;
        }
    }


    public String readFile() {
        try {
            return Files.lines(Paths.get(fileName))
                    .collect(Collectors.joining());
        } catch (IOException e) {
            return ("File" + fileName + " not found");
        }
    }


    public long countPunctuationMarks() {
        return readFile().chars()
                .filter(c -> !Character.isLetterOrDigit(c) && !Character.isSpaceChar(c))
                .count();
    }


    public long countWords() {
        return Stream.of(readFile().replaceAll("[0-9]+", "").split(" "))
                .filter(s -> s.trim().length() > 0)
                .filter(s -> Character.isLetter(s.charAt(0)))
                .count();
    }


    public List<Integer> getAllNumbers() {
        return Stream.of(readFile()
                .replaceAll("[^0-9]+", " ").split(" "))
                .filter(s -> s.trim().length() > 0)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }


    public long sumNumbers() {
        return getAllNumbers().stream()
                .reduce(0, (a, b) -> a + b);
    }


    public List<Integer> getUniqueNumbers() {
        return getAllNumbers().stream()
                .distinct()
                .collect(Collectors.toList());
    }
}

