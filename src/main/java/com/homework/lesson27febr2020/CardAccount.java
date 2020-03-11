package main.java.com.homework.lesson27febr2020;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * The type Card account.
 */
public class CardAccount implements Security, Serializable {
    private final String TYPE = "Visa";
    private String owner = "";
    private long number = 0L;
    private String wordUnblock = "";
    private GregorianCalendar validity;
    private String PIN = "";
    private int countTrials = 0;
    private long balance;
    private boolean isBlocked;
    private boolean isArrested;
    private transient static final long serialVersionUID = 1L;

    /**
     * The Scan.
     */
    transient Scanner scan = new Scanner(System.in);

    /**
     * Instantiates a new Card account.
     *
     * @param owner       the owner
     * @param wordUnblock the word unblock
     * @param balance     the balance
     * @param number      the number
     */
    public CardAccount(final String owner,final String wordUnblock,final long balance,final long number) {
        this.owner = owner;
        this.wordUnblock = wordUnblock;
        this.balance = balance;

        GregorianCalendar production = new GregorianCalendar();
        production.add(Calendar.YEAR, 2);
        GregorianCalendar validity = production;
        this.validity = validity;
        System.out.println("Ваш PIN: ");
        int pin = (int) (Math.random() * 10000 + 1000);
        PIN = String.valueOf(pin);
        System.out.println(PIN);
    }


    @Override
    public boolean checkValidity() {
        GregorianCalendar today = new GregorianCalendar();
        boolean isActual = this.validity.after(today);
        return isActual;
    }

    @Override
    public boolean verifyPIN() {
        boolean isCorrect = false;
        while (!isCorrect) {
            System.out.println("Введите PIN: ");
            Scanner scan = new Scanner(System.in);
            String pin = scan.nextLine();
            isCorrect = (pin.equals(this.PIN));
            if (!isCorrect) {
                this.countTrials++;
                System.out.println("Неправильный PIN");
            }
            if (this.countTrials == 3) {
                this.isBlocked = true;
                System.out.println("Карта заблокирована");
                this.unblockCard();
            }
        }
        return isCorrect;
    }

    @Override
    public void unblockCard() {
        for (int i = 3; i > 0; i--) {
            System.out.printf("Введите кодовое слово. У Вас %s попытки. ", i);
            System.out.println();
            Scanner scan = new Scanner(System.in);
            String word = scan.nextLine();
            if (word.equals(wordUnblock)) {
                this.isBlocked = false;
                System.out.println("Карта разблокирована.");
                return;
            }
        }
        this.isArrested = true;
        System.out.println("Ваша карта задержана, обратитесь в отделение банка.");
        return;
    }

    /**
     * Gets balance.
     *
     * @return the balance
     */
    public long getBalance() {
        return balance;
    }

    /**
     * Increase balance on sum of cash insert in ATM.
     */
    public void increaseBalance(long sumIn) {
        this.balance += sumIn;
    }

    /**
     * Decrease balance on sum of cash get out of ATM.
     */
    public void decreaseBalance(long sumOut) {
        this.balance -= sumOut;
    }


    /**
     * Gets number of the card account.
     *
     * @return the number
     */
    public long getNumber() {
        return number;
    }

}
