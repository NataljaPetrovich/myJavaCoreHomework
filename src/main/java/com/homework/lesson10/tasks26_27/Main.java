package main.java.com.homework.lesson10.tasks26_27;

public class Main {
    public static void main(String[] args) {
        Journal myClass = new Journal("7F", 12);
        System.out.println(myClass);
        myClass.removeBadMarks();
        myClass.setNewMarks();
        System.out.println(myClass);
        myClass.removeRepeating();
    }
}
