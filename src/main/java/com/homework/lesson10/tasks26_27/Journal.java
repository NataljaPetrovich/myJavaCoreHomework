package main.java.com.homework.lesson10.tasks26_27;

import java.util.ArrayList;
import java.util.Random;

/**
 * The type Journal. Contains class name, number of pupils in it, their marks.
 */
public class Journal {
    private String classNumber;
    private int numPupils;
    private ArrayList marks;
    /**
     * The Rand.
     */
    Random rand = new Random();

    /**
     * Instantiates a new Journal.
     *
     * @param classNumber the class name
     * @param numPupils   the number of pupils
     */
    public Journal(String classNumber, int numPupils) {
        this.classNumber = classNumber;
        this.numPupils = numPupils;
        this.marks = new ArrayList(numPupils);
        for (int i = 0; i < numPupils; i++) {
            (this.marks).add(rand.nextInt(10) + 1);
        }
    }

    /**
     * Sets new marks.
     */
    public void setNewMarks() {
        for (int i = 0; i < this.numPupils; i++) {
            if (i < (this.marks).size()) {
                (this.marks).set(i, (rand.nextInt(10) + 1));
            } else {
                (this.marks).add(i, (rand.nextInt(10) + 1));
            }
        }
    }

    /**
     * Remove mark.
     *
     * @param m the m
     */
    public void removeMark(int m) {
        while ((this.marks).contains(m)) {
            int toRemove = (this.marks).indexOf(m);
            (this.marks).remove(toRemove);
        }
    }

    /**
     * Remove bad marks (which are less than 3).
     */
    public void removeBadMarks() {
        this.removeMark(2);
        this.removeMark(1);
        System.out.println("Without bad marks (<3): " + this.marks);
    }

    /**
     * Remove repeating marks.
     */
    public void removeRepeating() {
        for (int i = 0; i < ((this.marks).size() - 1); i++) {
            Object mark = (this.marks).get(i);
            if ((this.marks).indexOf(mark) != (this.marks).lastIndexOf(mark)) {
                (this.marks).remove(mark);
            }
        }
        System.out.println("Without repeating marks : " + this.marks);
    }

    @Override
    public String toString() {
        return "Journal{" +
                "classNumber='" + classNumber + '\'' +
                ", numPupils=" + numPupils +
                ", marks=" + marks +
                '}';
    }
}
