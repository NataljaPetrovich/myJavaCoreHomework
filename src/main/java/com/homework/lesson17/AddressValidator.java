package main.java.com.homework.lesson17;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressValidator {
    //private static final String regex = " *(E|D|R) *([0-9] *){12}";
    private static final String regex = "\\s*[EDR]\\s*([0-9]\\s*){12}";

    public static boolean addressIsValid(String address){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(address);
        if(matcher.matches()){
          return true;
        }
        return false;
    }
}
