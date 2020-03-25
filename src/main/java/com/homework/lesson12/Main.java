package main.java.com.homework.lesson12;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //Task 30: Create text file, read it, count punctuation marks and words amount in the text.
        String text = "This is ... a test text. It contains 10 10punctuation marks! And words: 11, 11? ;0)";
        String fileName = "task30";
        FileWithText task30 = new FileWithText(fileName, text);
        System.out.println("Text: " + task30.readFile());
        System.out.println("Number of punctuation marks: " + task30.countPunctuationMarks());
        System.out.println("Number of words in the text: " + task30.countWords());

        //Task 31: You have text file, which contains numbers. Find all numbers, print them, count sum,
        // delete all repeating numbers and print remaining.
        System.out.println("All numbers in text: " + task30.getAllNumbers());
        System.out.println("Sum of all numbers: " + task30.sumOfNumbers());
        System.out.println("Numbers without repeating: " + task30.getUniqueNumbers());


        //Task 32: Write 20 random numbers into a binary file. Read this file, print numbers, find average.
        RandomDataFile task32 = new RandomDataFile("task32.dat");
        task32.showContent();
        task32.showAverage();
    }
}
