package main.java.com.homework.lesson10.task29.stream;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrDictionary {
    public static void main(String[] args) {
        String[] wordsInText = {"dodo", "is", "dead", "like", "dodo"};
        Map<String, Long> freq =
                Stream.of(wordsInText)
                        .collect(Collectors.groupingBy(Function.identity(),
                                Collectors.counting()));
        System.out.println(freq);
    }
}
