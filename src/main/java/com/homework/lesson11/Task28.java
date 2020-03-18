package main.java.com.homework.lesson11;
/*
 * Task #28:
 * Create a list of pupils' marks (ArrayList), fill in randomly. Find highest one using iterator.
 * */

public class Task28 {
    public static void main(String[] args) {
        Journal class6A = new Journal(20);
        class6A.setMarks();
        System.out.println(class6A);
        System.out.println("Maximal mark:" + class6A.getMaxMark());
    }
}
