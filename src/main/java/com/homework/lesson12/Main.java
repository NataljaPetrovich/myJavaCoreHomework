package main.java.com.homework.lesson12;


public class Main {
    public static void main(String[] args) {

        //Task 30: Create text file, read it, count punctuation marks and words amount in the text.
        //Task 31: You have text file, which contains numbers. Find all numbers, print them, count sum,
        // delete all repeating numbers and print remaining.

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

        //Task #32: write in file 20 random numbers; read this file,
        // print all numbers and their average.

        Task32 testData = new Task32("task32.dat", 20);
        if (testData.createRandomDataFile()) {
            System.out.print("Data: ");
            testData.printData();
            System.out.println("Average: " + testData.getAverage());
        }
