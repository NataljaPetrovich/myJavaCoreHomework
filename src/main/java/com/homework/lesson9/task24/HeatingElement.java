package main.java.com.homework.lesson9.task24;

/**
 * The interface Heating element.
 */
public interface HeatingElement {
    /**
     * Sets temperature regimes.
     *
     * @param t the t
     */
    void setRegime(int... t);

    /**
     * You can choose temperature regime.
     *
     * @param regime the regime
     */
    int switchRegime(int regime);
}
