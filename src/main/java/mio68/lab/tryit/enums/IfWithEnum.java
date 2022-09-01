package mio68.lab.tryit.enums;

import static mio68.lab.tryit.enums.IfWithEnum.Suit.*;

public class IfWithEnum {

    private final Suit suit;

    public enum Suit {
        CLUB, DIAMOND, HEART, SPADE
    }

    public IfWithEnum(Suit suit) {
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public static void main(String[] args) {

        IfWithEnum ifWithEnum = new IfWithEnum(DIAMOND);

        if (ifWithEnum.getSuit() == DIAMOND) {
            System.out.println("It's suit is " + DIAMOND);
        }

    }

}
