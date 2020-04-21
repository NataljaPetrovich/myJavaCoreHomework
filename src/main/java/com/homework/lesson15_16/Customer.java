package main.java.com.homework.lesson15_16;

import java.util.ArrayList;
import java.util.Random;


public class Customer implements Runnable {
    private int number;
    private ArrayList<String> goodsToBuy;
    static int count = 0;

    public Customer() {
        count++;
        number = count;
        goodsToBuy = new ArrayList<>();
    }

    void putGoodsInBasket(ArrayList<String> goodsInShop) {
        Random random = new Random();
        int numOfGoods = random.nextInt(7);
        while (numOfGoods >= 0) {
            int i = random.nextInt(goodsInShop.size());
            goodsToBuy.add(goodsInShop.get(i));
            numOfGoods--;
        }
    }

    void showGoodsInBasket() {
        System.out.println(goodsToBuy);
    }

    @Override
    public void run() {
        synchronized (goodsToBuy) {
            System.out.println("Покупатель №" + number);
            for (String s : goodsToBuy) {
                System.out.print(s + "; ");
            }
            System.out.println("Всего товаров: " + goodsToBuy.size());
            /*try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}
