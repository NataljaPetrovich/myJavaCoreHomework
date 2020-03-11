package main.java.com.homework.lesson9.task24;

import java.util.Arrays;

/**
 * The type Iron.
 */
public class Iron extends ElectricalAppliance implements HeatingElement {
    private int[] temperatReg;

    /**
     * Instantiates a new Iron.
     *
     * @param name         the name
     * @param manufacturer the manufacturer
     */
    public Iron(String name, String manufacturer) {
        super(name, manufacturer);
    }

    @Override
    void showStatus() {
        if (this.isON) {
            System.out.println("Small indicator light on iron switches on");
        }
    }

    @Override
    void functioning() {
        System.out.println("Iron begin heating.");
    }


    @Override
    public void setRegime(int... t) {
        temperatReg = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            temperatReg[i] = t[i];
        }
    }

    @Override
    public int switchRegime(int regime) {
        return temperatReg[regime];
    }

    @Override
    public String toString() {
        return "Iron{" +
                "temperatReg=" + Arrays.toString(temperatReg) +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", isON=" + isON +
                '}';
    }
}
