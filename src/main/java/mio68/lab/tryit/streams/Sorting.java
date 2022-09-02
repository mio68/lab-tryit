package mio68.lab.tryit.streams;

import lombok.Data;
import mio68.lab.tryit.model.Card;

import java.util.Comparator;
import java.util.List;

import static mio68.lab.tryit.model.Card.Suit.*;
import static mio68.lab.tryit.model.Card.Rank.*;

public class Sorting {

    public static void main(String[] args) {

        List<Card> cards = List.of(
                new Card(DIAMOND, DEUCE),
                new Card(CLUB, DEUCE),
                new Card(HEART, QUEEN),
                new Card(CLUB, ACE),
                new Card(HEART, ACE),
                new Card(SPADE, QUEEN),
                new Card(CLUB, KING)
        );

//        System.out.println("Natural sort -----------");
//        // Exception in thread "main" java.lang.ClassCastException: class mio68.lab.tryit.model.Card cannot be cast to class java.lang.Comparable (mio68.lab.tryit.model.Card is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
//        cards.stream()
//                .sorted()
//                .forEach(System.out::println);

        System.out.println("Sort by suit -----------");
        cards.stream()
                .sorted(Comparator.comparing(Card::getSuit))
                .forEach(System.out::println);

        System.out.println("Sort by rank -----------");
        cards.stream()
                .sorted(Comparator.comparing(Card::getRank))
                .forEach(System.out::println);

        System.out.println("Sort by suit then by rank -----------");
        cards.stream()
                .sorted(Comparator.comparing(Card::getSuit).thenComparing(Card::getRank))
                .forEach(System.out::println);


    }


}
