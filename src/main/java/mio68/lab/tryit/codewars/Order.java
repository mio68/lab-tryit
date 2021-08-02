package mio68.lab.tryit.codewars;

import java.util.*;
import java.util.stream.Collectors;

public class Order {
    public static String order(String words) {
        return orderImproved3(words);
    }

        public static String orderDummy(String words) {
        String [] singleWords = words.split(" ");
        for(int searchForIdx = 0; searchForIdx < singleWords.length - 1; searchForIdx++) {
            char searchForChar = (char) ('1' + searchForIdx);
            for (int i = searchForIdx; i < singleWords.length; i++) {
                if (singleWords[i].indexOf(searchForChar) != -1 ) {
                    String tmp = singleWords[searchForIdx];
                    singleWords[searchForIdx] = singleWords[i];
                    singleWords[i] = tmp;
                    break;
                }
            }
        }
        return String.join(" ", singleWords);
    }

    public static String orderImproved(String words) {
        if( words.isEmpty() )
            return words;

        String [] singleWords = words.split(" ");
        String [] orderedWords = new String[singleWords.length];
        for (String word : singleWords)
            orderedWords[ getIndex(word) ] = word;
        return String.join(" ", orderedWords);
    }

    public static String orderImproved2(String words) {
        if( words.isEmpty() )
            return words;

        return Arrays.stream(words.split(" "))
                .sorted((w1,w2)-> getIndex(w1).compareTo(getIndex(w2)))
                .collect(Collectors.joining(" "));
    }

    public static String orderImproved3(String words) {
        if( words.isEmpty() )
            return words;

        return Arrays.stream(words.split(" "))
                .sorted( Comparator.comparing( w -> w.replaceAll("\\D","")))
                .collect(Collectors.joining(" "));
    }



    public static HashMap<String,Integer> wordIndex = new HashMap<>(9);
    public static Integer getIndex(String word) {
        Integer idx = wordIndex.get(word);
        if(idx == null)
            idx = word.chars().filter(Character::isDigit).findFirst().getAsInt() - '1';
        return idx;
    }
}