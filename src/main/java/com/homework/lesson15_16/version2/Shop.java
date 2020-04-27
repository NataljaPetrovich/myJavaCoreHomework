package main.java.com.homework.lesson15_16.version2;


public class Shop {
    static String[] goods = {"салфетки-1", "мясо-15", "яйца-3", "морковь-2", "молоко-1", "сыр-4",
            "кефир-1", "сок-2", "сигареты-2", "хлеб-1", "вино-17", "лук-1", "гречка-2"};


    public static void main(String[] args) {
        turnOnCashRegisters(4);
    }


    static void turnOnCashRegisters(int numberOfCashRegisters) {
        int number = 1;
        while (number <= numberOfCashRegisters) {
            CashRegister c = new CashRegister();
            c.setName("Касса №" + number);
            c.start();
            number++;
        }
    }
}
