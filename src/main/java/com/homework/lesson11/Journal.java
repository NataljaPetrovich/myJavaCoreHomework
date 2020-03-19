package main.java.com.homework.lesson11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * The type Journal.
 */
public class Journal {
    private ArrayList<Integer> classJournal;
    private int numOfPupils;

    /**
     * Instantiates a new Journal.
     *
     * @param np the np
     */
    Journal(final int np) {
        numOfPupils = np;
        classJournal = new ArrayList<>(np);
    }

    /**
     * Sets marks of pupils randomly.
     */
    public void setMarks() {
        Stream
                .generate(() -> ((int) (Math.random() * 10) + 1))
                .limit(numOfPupils)
                .forEach(i -> classJournal.add(i));
    }

    /**
     * Get max mark integer.
     *
     * @return the integer
     */
    public Integer getMaxMark() {
        Integer maxMark = 0;
        Iterator <Integer> iterator = classJournal.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i > maxMark) {
                maxMark = i;
            }
        }
        return maxMark;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "classJournal=" + classJournal +
                '}';
    }
}
