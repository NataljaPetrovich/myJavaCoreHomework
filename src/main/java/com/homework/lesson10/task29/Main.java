package main.java.com.homework.lesson10.task29;

public class Main {
    public static void main(String[] args) {
        String txt = "Old MacDonald had a farm Ee i ee i o And on his farm he had some cows Ee i ee i oh " +
                "With a moo-moo here And a moo-moo there Here a moo, there a moo Everywhere a moo-moo " +
                "Old MacDonald had a farm Ee i ee i o Old MacDonald had a farm Ee i ee i o";
        FrequencyDictionary mcdonald = new FrequencyDictionary(txt);
        mcdonald.showFrequences();
        mcdonald.showNumOfUse();
    }

}
