package main.java.com.homework.lesson15_16.version2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Customer extends Thread {
    ArrayList<String> goodsToBuy;
    ArrayList<String> check;

    Customer(int number) {
        this.setName("Покупатель №" + number);
        goodsToBuy = new ArrayList<>();
    }

    @Override
    public void run() {
        putGoodsInBasket();
        scanGoods();
    }

    void putGoodsInBasket() {
        Random random = new Random();
        int numOfGoods = random.nextInt(7);
        ArrayList<String> goodsInShop = (ArrayList<String>) Arrays.stream(Shop.goods).collect(Collectors.toList());
        while (numOfGoods >= 0) {
            int i = random.nextInt(goodsInShop.size());
            goodsToBuy.add(goodsInShop.get(i));
            numOfGoods--;
        }
    }

    synchronized void scanGoods() {
        check = new ArrayList<>();
        int totalCost = 0;
        for (String s : goodsToBuy) {
            check.add(s + " руб.");
            String[] splitS = s.split("-");
            totalCost += Integer.parseInt(splitS[1]);
        }
        check.add("Всего товаров: " + goodsToBuy.size());
        check.add(" К оплате: " + totalCost + " руб.");
    }
}
