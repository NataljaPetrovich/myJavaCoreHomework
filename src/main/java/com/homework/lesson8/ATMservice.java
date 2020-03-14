package main.java.com.homework.lesson8;

/**
 * The interface ATMservice.
 */
interface ATMservice {
    /**
     * Cash in. Method to put banknotes into ATM.
     *
     * @param banknotes100 the banknotes 100
     * @param banknotes50  the banknotes 50
     * @param banknotes20  the banknotes 20
     */
    void cashIn(int banknotes100, int banknotes50, int banknotes20);

    /**
     * Cash out boolean. Method to get banknotes out of ATM.
     *
     * @param sum the sum
     * @return the boolean
     */
    boolean cashOut(long sum);
}
