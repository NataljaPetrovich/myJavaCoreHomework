package main.java.com.homework.lesson27febr2020;

/**
 * The type ATM.
 * Container for cash.
 */
public class ATM {
    private int banknotes100, banknotes50, banknotes20;
    private boolean possible;

    /**
     * Instantiates a new Atm.
     *
     * @param banknotes100 the banknotes 100
     * @param banknotes50  the banknotes 50
     * @param banknotes20  the banknotes 20
     */
    public ATM(int banknotes100, int banknotes50, int banknotes20) {
        this.banknotes100 = banknotes100;
        this.banknotes50 = banknotes50;
        this.banknotes20 = banknotes20;
    }

    /**
     * Cash in.
     * The way to refill cash in ATM.
     *
     * @param banknotes100 the banknotes 100
     * @param banknotes50  the banknotes 50
     * @param banknotes20  the banknotes 20
     */
    public void cashIn(int banknotes100, int banknotes50, int banknotes20) {
        this.banknotes100 += banknotes100;
        this.banknotes50 += banknotes50;
        this.banknotes20 += banknotes20;
    }

    /**
     * Cash out boolean.
     * Gives out required sum if it's possible
     *
     * @param sum the sum
     * @return the boolean
     */
    public boolean cashOut(int sum) {
        int outBankn100, outBankn50, outBankn20;
        outBankn20 = outBankn50 = outBankn100 = 0;
        long sumCashIn = banknotes20 * 20 + banknotes50 * 50 + banknotes100 * 100;
        if (sum <= sumCashIn) {
            if ((sum / 100) <= banknotes100) {
                outBankn100 = sum / 100;
            } else {
                outBankn100 = banknotes100;
            }
            sum -= (outBankn100 * 100);
            if (sum > 0) {
                if ((sum / 50) <= banknotes50) {
                    outBankn50 = sum / 50;
                } else {
                    outBankn50 = banknotes50;
                }
            }
            sum -= (outBankn50 * 50);
            if (sum > 0) {
                if ((sum % 20 == 0) && (sum / 20) <= banknotes20) {
                    outBankn20 = sum / 20;
                    sum = 0;
                    possible = true;
                } else if (((sum + 50) % 20 == 0) && (((sum + 50) / 20) <= banknotes20)) {
                    sum += 50;
                    if (outBankn50 > 0) {
                        outBankn20 = sum / 20;
                        outBankn50--;
                        sum = 0;
                        possible = true;
                    } else if (outBankn100 > 0) {
                        outBankn20 = sum / 20;
                        outBankn50++;
                        outBankn100--;
                        sum = 0;
                    }
                }
            }
            if (sum == 0) {
                System.out.printf("Выдано купюр: номиналом 100 руб. %s, номиналом 50 руб. %s, номиналом 20 руб. %s ",
                        outBankn100, outBankn50, outBankn20);
                System.out.println();
            } else {
                System.out.println("Введите сумму кратную 100, 50 или 20 руб.");
            }
        } else {
            System.out.println("Нет возможности выдать запрашиваемую сумму.");
        }
        banknotes100 -= outBankn100;
        banknotes50 -= outBankn50;
        banknotes20 -= outBankn20;
        return possible;
    }

    /**
     * Menu.
     * Prints out menu.
     */
    public void menu() {
        System.out.println("Нажмите 1 чтобы узнать балланс Вашего счёта.");
        System.out.println("Нажмите 2 чтобы пополнить Ваш счёт.");
        System.out.println("Нажмите 3 чтобы снять наличные.");
        System.out.println("Нажмите 0 для завершения работы.");
    }
}

