package main.java.com.homework.lesson15_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Shop {
    ArrayList<String> goodsInShop;
    ExecutorService cashRegisters;

    Shop(int numberOfCashRegisters, String... goods) {
        cashRegisters = Executors.newFixedThreadPool(numberOfCashRegisters);
        goodsInShop = (ArrayList<String>) Arrays.stream(goods).collect(Collectors.toList());
    }

    public void serveAllCustomers(Customer... customers) {
        for (Customer c : customers) {
            cashRegisters.execute(c);
            try {
                cashRegisters.awaitTermination(500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        cashRegisters.shutdown();
    }
}

