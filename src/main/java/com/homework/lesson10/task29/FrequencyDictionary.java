package main.java.com.homework.lesson10.task29;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;


/**
 * The type Frequency dictionary.
 */
public class FrequencyDictionary {
    private String text;
    private ArrayList<String> words;
    private Map<String, Integer> frequDict;

    /**
     * Instantiates a new Frequency dictionary.
     *
     * @param txt the txt
     */
    public FrequencyDictionary(final String txt) {
        this.text = txt;
        String s = txt.toLowerCase();
        this.words = this.toArrayList(s);
        this.frequDict = this.toFrequDict();
    }


    private ArrayList toArrayList(String s) {
        ArrayList text = new ArrayList();
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (!(Character.isLetterOrDigit(array[i]))) {
                array[i] = ' ';
            }
        }
        s = String.valueOf(array);
        String[] word = s.split(" ");
        for (int i = 0; i < word.length; i++) {
            word[i].trim();
            if (word[i].length() > 0) {
                text.add(word[i]);
            }
        }
        return text;
    }


    /**
     * To frequ dict map.
     *
     * @return the map
     */
    public Map<String, Integer> toFrequDict() {
        HashMap<String, Integer> temp = new HashMap<String, Integer>();
        for (String i : this.words) {
            Integer j = temp.get(i);
            temp.put(i, (j == null) ? 1 : j + 1);
        }
        Map<String, Integer> frqD = new TreeMap<String, Integer>(temp);
        return frqD;
    }


    /**
     * Show frequences.
     */
    public void showFrequences() {
        for (Map.Entry<String, Integer> entry : frequDict.entrySet()) {
            System.out.println("Word's \"" + entry.getKey() + "\" frequency is " + ((double)entry.getValue()/this.words.size()*100) + " per 100.");
        }
    }

    public void showNumOfUse(){
        for (Map.Entry<String, Integer> entry : frequDict.entrySet()) {
            System.out.println("Word \"" + entry.getKey() + "\" is used " + entry.getValue() + " times.");
        }
    }

    @Override
    public String toString() {
        return "FrequencyDictionary{" +
                "text='" + text + '\'' +
                ", frequDict=" + frequDict +
                '}';
    }
}

