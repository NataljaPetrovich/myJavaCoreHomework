package main.java.com.homework.lesson10.tasks26_27;

public class Main {
    public static void main(String[] args) {
        /*
         * Task #26:
         * Create list of pupils' marks (ArrayList), fill in randomly. Remove unsatisfactory marks (less than 3).
         *
         * Task #27:
         * Create collection, fill in by random numbers. Remove all repeating numbers.
         *
         * */

        //Task26
        Journal myClass = new Journal("7F", 12);
        System.out.println(myClass);
        myClass.removeBadMarks();

        //Task27
        myClass.setNewMarks();
        System.out.println(myClass);
        myClass.removeRepeating();
    }
}
