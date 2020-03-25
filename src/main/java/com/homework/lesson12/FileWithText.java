package main.java.com.homework.lesson12;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * The type File with text.
 */
public class FileWithText {
    /**
     * The File name.
     */
    String fileName;
    /**
     * The Text.
     */
    String text;

    /**
     * Instantiates a new File with text.
     *
     * @param fileName the file name
     * @param text     the text
     */
    FileWithText(String fileName, String text) {
        this.fileName = fileName;
        this.text = text;
        PrintWriter writer;
        try {
            writer = new PrintWriter(fileName);
            writer.print(text);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /**
     * Read file string.
     *
     * @return the string
     * @throws IOException the io exception
     */
    public String readFile() throws IOException {
        return Files.lines(Paths.get(fileName))
                .collect(Collectors.joining());

    }

    /**
     * Count punctuation marks long.
     *
     * @return the long
     * @throws IOException the io exception
     */
    public long countPunctuationMarks() throws IOException {
        return readFile().chars()
                .filter(c -> !Character.isLetterOrDigit(c) && !Character.isSpaceChar(c))
                .count();
    }

    /**
     * Count words long.
     *
     * @return the long
     * @throws IOException the io exception
     */
    public long countWords() throws IOException {
        return Stream.of(readFile().split(" "))
                .filter(s -> s.trim().length() > 0)
                .filter(s -> Character.isLetter(s.charAt(0)))
                .count();
    }

    /**
     * Gets all numbers.
     *
     * @return the all numbers
     * @throws IOException the io exception
     */
    public List<Integer> getAllNumbers() throws IOException {
        return Stream.of(readFile().replaceAll("[^0-9]+", " ").split(" "))
                .filter(s -> s.trim().length() > 0)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    /**
     * Sum of numbers long.
     *
     * @return the long
     * @throws IOException the io exception
     */
    public long sumOfNumbers() throws IOException {
        return getAllNumbers().stream()
                .reduce(0, (a, b) -> a + b);
    }

    /**
     * Gets unique numbers.
     *
     * @return the unique numbers
     * @throws IOException the io exception
     */
    public List<Integer> getUniqueNumbers() throws IOException {
        return getAllNumbers().stream()
                .distinct()
                .collect(Collectors.toList());
    }
}

