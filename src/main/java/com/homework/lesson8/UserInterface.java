package main.java.com.homework.lesson8;

import java.io.*;
import java.util.Scanner;

/**
 * The type User interface.
 */
public class UserInterface {
    /**
     * The Atm. Connects with ATM.
     */
    ATM atm = new ATM();
    /**
     * The Scan.
     */
    Scanner scan = new Scanner(System.in);

    /**
     * Switch on user interface on this ATM.
     *
     * @return the user interface
     */
    public void startWork() {
        System.out.println("Вставьте карту (нажмите 1)." + "\n"
                + "Или обратитесь в банк, чтобы завести новую карту (нажмите 2)" + "\n"
                + "Нажмите 0 для завершения работы");
        String choise1 = scan.nextLine();
        switch (choise1) {
            case "0":
                System.out.println("Работа завершена");
                break;
            case "1":
                System.out.println("Введите номер карты ");
                String cNum = scan.nextLine();
                long cardNum = Long.parseLong(cNum);
                CardAccount yourCard = this.getCard(cardNum);
                if (yourCard != null) {
                    if (yourCard.checkValidity()) {
                        boolean truePIN = yourCard.verifyPIN();
                        if (truePIN) {
                            this.menu(yourCard);
                        }
                    } else {
                        System.out.println("Срок действия карты закончился.");
                    }
                }
                break;
            case "2":
                this.menu(this.getNewCard());
                break;
            default:
                System.out.println("Ошибка");
        }
    }

    /**
     * Menu. Main menu to perform transactions.
     *
     * @param yourCard the your card
     */
    public void menu(final CardAccount yourCard) {
        CardAccount activeCard = yourCard;
        boolean work = true;
        while (work) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Нажмите 1 чтобы узнать балланс Вашего счёта.");
            System.out.println("Нажмите 2 чтобы пополнить Ваш счёт.");
            System.out.println("Нажмите 3 чтобы снять наличные.");
            System.out.println("Нажмите 0 для завершения работы.");
            String choise2 = scan.nextLine();
            switch (choise2) {
                case "1":
                    System.out.printf("Баланс вашего счета: + %d%n", activeCard.getBalance());
                    break;
                case "2":
                    System.out.println("Введите количество купюр номиналом 100 руб.");
                    String b100 = scan.nextLine();
                    System.out.println("Введите количество купюр номиналом 50 руб.");
                    String b50 = scan.nextLine();
                    System.out.println("Введите количество купюр номиналом 20 руб.");
                    String b20 = scan.nextLine();
                    int bankn100 = Integer.parseInt(b100);
                    int bankn50 = Integer.parseInt(b50);
                    int bankn20 = Integer.parseInt(b20);
                    atm.cashIn(bankn100, bankn50, bankn20);
                    long sumIn = bankn20 * 20 + bankn50 * 50 + bankn100 * 100;
                    activeCard.increaseBalance(sumIn);
                    System.out.printf("Операция прошла успешно. Баланс вашего счета: + %d%n", activeCard.getBalance());
                    break;
                case "3":
                    System.out.println("Введите сумму, которую желаете снять: ");
                    String sOut = scan.nextLine();
                    long sumOut = Long.parseLong(sOut);
                    if (sumOut > activeCard.getBalance()) {
                        System.out.println("У Вас недостаточно средств.");
                    } else {
                        boolean canGive = atm.cashOut(sumOut);
                        if (canGive) {
                            activeCard.decreaseBalance(sumOut);
                        }
                    }
                    break;
                case "0":
                    this.finishWork(activeCard);
                    work = false;
                    break;
                default:
                    System.out.println("Ошибка");
            }
        }
    }

    /*
     * Finds card account by it's number.
     */
    private CardAccount getCard(long cardNum) {
        String fileName = "./" + cardNum;
        File yourCard = new File(fileName);
        CardAccount card = null;
        if (yourCard.canRead()) {
            FileInputStream fis = null;
            ObjectInputStream in = null;
            try {
                fis = new FileInputStream(fileName);
                in = new ObjectInputStream(fis);
                card = (CardAccount) in.readObject();
                in.close();
                return card;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Карта с таким номером не обнаружена");
        }
        return card;
    }

    /*
     * The way to get new card account.
     */
    private CardAccount getNewCard() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя владельца ");
        String owner = scan.nextLine();
        System.out.println("Введите номер карты");
        String numb = scan.nextLine();
        long number = Long.parseLong(numb);
        System.out.println("Введите кодовое слово для разблокировки карты ");
        String wordUnblock = scan.nextLine();
        System.out.println("Введите сумму, которую желаете положить на счет ");
        String bal = scan.nextLine();
        long balance = Long.parseLong(bal);
        CardAccount newCard = new CardAccount(owner, wordUnblock, balance, number);
        String filePath = "./" + number;
        File card = new File(filePath);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filePath);
            out = new ObjectOutputStream(fos);
            out.writeObject(newCard);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newCard;
    }

    /*
     * Saves changes in currently used card account.
     */
    private void finishWork(CardAccount activeCard) {
        String filePath = "./" + activeCard.getNumber();
        File card = new File(filePath);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filePath);
            out = new ObjectOutputStream(fos);
            out.writeObject(activeCard);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
