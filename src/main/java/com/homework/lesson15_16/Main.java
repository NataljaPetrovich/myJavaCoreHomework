package main.java.com.homework.lesson15_16;

public class Main {
    public static void main(String[] args) {
        String[] newGoods = {"салфетки", "мясо", "яйца", "морковь", "молоко", "сыр",
                "кефир", "сок", "сигареты", "хлеб", "вино", "лук", "гречка"};
        Shop euroSpar = new Shop(4, newGoods);
        Customer[] customers = new Customer[7];
        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer();
        }
        for (Customer c : customers) {
            c.putGoodsInBasket(euroSpar.goodsInShop);
        }
        euroSpar.serveAllCustomers(customers);


        //Проверка корректности вывода списков покупок
        /*try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Test: ");
        int i = 1;
        for (Customer c : customers) {
            System.out.print("Покупатель №" + i++ + ":");
            c.showGoodsInBasket();
        }*/
    }
}
