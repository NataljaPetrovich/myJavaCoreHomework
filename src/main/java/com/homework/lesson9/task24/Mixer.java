package main.java.com.homework.lesson9.task24;

import java.util.Arrays;

/**
 * The type Mixer.
 */
public class Mixer extends KitchenAppliance {
    /**
     * The Regimes.
     */
    int[] regimes;

    /**
     * Instantiates a new Mixer.
     *
     * @param name         the name
     * @param manufacturer the manufacturer
     * @param method       the method
     */
    public Mixer(String name, String manufacturer, String method) {
        super(name, manufacturer, method);
    }

    @Override
    void showStatus() {
        if (isON) {
            System.out.println("Mixer begins shaking up.");
        }
    }

    @Override
    void functioning() {
        System.out.println("Switch regime you need and shake up or mix everything you want.");
    }


    /**
     * Switch regimes int.
     *
     * @param regime the regime
     * @return the int
     */
    public int switchRegimes(int regime) {
        return this.regimes[regime];
    }

    /**
     * Sets regimes.
     *
     * @param regimes the regimes
     */
    public void setRegimes(int... regimes) {
        for (int i = 0; i < regimes.length; i++) {
            this.regimes[i] = regimes[i];
        }
    }

    @Override
    public String toString() {
        return "Mixer{" +
                "regimes=" + Arrays.toString(regimes) +
                ", methodOfUse='" + methodOfUse + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", isON=" + isON +
                '}';
    }
}
