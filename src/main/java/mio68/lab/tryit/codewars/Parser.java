package mio68.lab.tryit.codewars;

import java.util.HashMap;

public class Parser {
    private static final HashMap<String, Integer> numbers = new HashMap<>();

    static {
        numbers.put("zero",0);
        numbers.put("one",1);
        numbers.put("two",2);
        numbers.put("three",3);
        numbers.put("four",4);
        numbers.put("five",5);
        numbers.put("six",6);
        numbers.put("seven",7);
        numbers.put("eight",8);
        numbers.put("nine",9);
        numbers.put("ten",10);
        numbers.put("eleven",11);
        numbers.put("twelve",12);
        numbers.put("thirteen",13);
        numbers.put("fourteen",14);
        numbers.put("fifteen",15);
        numbers.put("sixteen",16);
        numbers.put("seventeen",17);
        numbers.put("eighteen",18);
        numbers.put("nineteen",19);
        numbers.put("twenty",20);
        numbers.put("thirty",30);
        numbers.put("forty",40);
        numbers.put("fifty",50);
        numbers.put("sixty",60);
        numbers.put("seventy",70);
        numbers.put("eighty",80);
        numbers.put("ninety",90);
        numbers.put("hundred",100);
        numbers.put("thousand",1000);
        numbers.put("million",1000000);
    }

    public static int parseInt(String numStr) {
        //prepare and split
        String[] words = numStr.replaceAll(" and |-"," ").split(" ");
        int total = 0, currentGroup = 0;
        for(String word : words) {
           int currentNumber = numbers.get(word);
           switch (currentNumber) {
               //detect three digit group multipliers and finish currentGroup
               case 1000:
               case 1000000: total += currentGroup * currentNumber; currentGroup = 0; break;
               //detect hundred multiplier
               case 100: currentGroup *= currentNumber; break;
               //just accumulate current group
               default: currentGroup += currentNumber;
           }
        }
        total += currentGroup; // take into account the last group
        return total;
    }
}