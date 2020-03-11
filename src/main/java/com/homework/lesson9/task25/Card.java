package main.java.com.homework.lesson9.task25;

abstract class Card {
    String bank;
    String owner;
    long balance;

    Card(final String b, final String o) {
        bank = b;
        owner = o;
    }

    abstract long getBalance();

    abstract void setBalance(final long balance);
}
    abstract class LocalCard extends Card {
        String region;

        LocalCard(final String b, final String o, final String r) {
            super(b, o);
            region = r;
        }
    }

    abstract class InternationalCard extends Card {
        String type;

        InternationalCard(final String b, final String o, final String t) {
            super(b, o);
            type = t;
        }
    }
