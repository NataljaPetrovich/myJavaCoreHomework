package main.java.com.homework.lesson9.task24;

import java.util.Arrays;

/**
 * The type Toaster.
 */
public class Toaster extends KitchenAppliance implements HeatingElement{
    private int[] temperatReg;

    /**
     * Instantiates a new Toaster.
     *
     * @param name         the name
     * @param manufacturer the manufacturer
     * @param method       the method
     */
    public Toaster(String name, String manufacturer, String method) {
        super(name, manufacturer, method);
    }


    @Override
    void showStatus() {
        if(isON) {
            System.out.println("Begins heating.");
        }
    }

    @Override
    void functioning() {
        System.out.println("Put a piece of bread, wait a minute, enjoy your delicious crunchy toast!");
    }

    @Override
    public void setRegime(int ... t) {
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
        return "Toaster{" +
                "temperature=" + temperatReg +
                ", temperatReg=" + Arrays.toString(temperatReg) +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", isON=" + isON +
                '}';
    }
}
