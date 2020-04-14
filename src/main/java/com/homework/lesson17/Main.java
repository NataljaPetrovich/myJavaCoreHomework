package main.java.com.homework.lesson17;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter your address: ");
        System.out.println(AddressValidator.addressIsValid(new Scanner(System.in).nextLine()));
    }
}
