package main.java.com.homework.lesson15_16.version2;


public class CashRegister extends Thread {

    @Override
    public void run() {
        long timeToEndWork = System.currentTimeMillis() + 77;
        int numberOfServedCustomers = 0;
        System.out.println(this.getName() + " включена.");
        while (System.currentTimeMillis() < timeToEndWork) {
            serveNextCustomer(++numberOfServedCustomers);
        }
        System.out.println(this.getName() + ": за рабочий день обслужено покупателей: " + numberOfServedCustomers);
    }

    synchronized void serveNextCustomer(int numberOfServedCustomer){
        Customer c = new Customer(numberOfServedCustomer);

        c.start();
        try {
            c.join();
        } catch (InterruptedException e) {
            System.out.println("Problem in " + Thread.currentThread().getName());
        }
        System.out.println(this.getName() + ": " +c.getName() + c.check);
    }
}
