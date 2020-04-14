package main.java.com.homework.lesson17;

import java.util.regex.Pattern;

public class AddressValidator {
    private static final String regex = "\\s*[EDR]\\s*([0-9]\\s*){12}";

    public static boolean addressIsValid(final String address) {
        return Pattern.matches(regex, address);
    }
}
