package main.java.com.homework.lesson15_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Shop {
    ArrayList<String> goodsInShop;
    int numberOfCashRegisters;
    ExecutorService cashRegisters;

    Shop(int numberOfCashRegisters, String... goods) {
        this.numberOfCashRegisters = numberOfCashRegisters;
        cashRegisters = Executors.newFixedThreadPool(numberOfCashRegisters);
        goodsInShop = (ArrayList<String>) Arrays.stream(goods).collect(Collectors.toList());
    }

    public void serveAllCustomers(Customer... customers) {
        int i = 0;
        while (i < customers.length) {
            int j;
            for (j = 0; j < numberOfCashRegisters && (i + j) < customers.length; j++) {
                System.out.println("Покупатель " + (i + j + 1) + " на кассе №" + (j + 1));
                cashRegisters.submit(customers[i + j]);
            }
            try {
                cashRegisters.awaitTermination(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            i += j;
        }
        cashRegisters.shutdown();
        try {
            cashRegisters.awaitTermination(500, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

