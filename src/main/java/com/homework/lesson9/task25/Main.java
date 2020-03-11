package main.java.com.homework.lesson9.task25;

public class Main {
    public static void main(String[] args) {
        OverdraftCard myCard = new OverdraftCard("Belarusbank", "Tom Soyer", "Visa", 2);
        myCard.setBalance(-100);
        System.out.println("Balance: " + myCard.getBalance());
        System.out.println("Debt per day: " + myCard.calcDebt());
    }
}