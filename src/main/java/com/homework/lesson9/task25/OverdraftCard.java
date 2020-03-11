package main.java.com.homework.lesson9.task25;

public class OverdraftCard extends InternationalCard {
    private int overdrPercent;
    private long debt;

    OverdraftCard(final String b, final String o, final String t, final int p) {
        super(b, o, t);
        overdrPercent = p;
    }

    @Override
    long getBalance() {
        return balance;
    }

    @Override
    void setBalance(final long balance) {
        this.balance = balance;
    }

    public long calcDebt() {
        if (this.getBalance() < 0) {
            this.debt = -this.getBalance() * overdrPercent/100;
        }else {
            this.debt = 0;
        }
        return debt;
    }
}
