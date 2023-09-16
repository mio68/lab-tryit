package mio68.lab.tryit.nested;

import mio68.lab.tryit.model.Card;
import mio68.lab.tryit.model.Person;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Nested {

    private final String title;

    public Nested(String title) {
        this.title = title;
    }

    public Person getPerson() {
        // anonymous
        return new Person() {
            @Override
            public String getFirstName() {
                return "John";
            }

            @Override
            public String getLastName() {
                return "Doe";
            }
        };
    }

    class InnerCard extends Card {
        // Something strange! Inner class defined static members!

        private static final AtomicInteger idGenerator = new AtomicInteger(0);
        private static final String description = "This is card class to be used with Nested instances";
        private static final Card.Suit DEFAULT_SUIT = Card.Suit.DIAMOND;
        private static final Card.Rank DEFAULT_RANK = Rank.ACE;
        private static String aStaticNonFinalMember;

        private String constructionDetails;
        private final int id;

        public InnerCard() {
            super(DEFAULT_SUIT, DEFAULT_RANK);
            constructionDetails = "Constructed with default suit and rank";
            id = idGenerator.incrementAndGet();
        }

        public InnerCard(Suit suit, Rank rank) {
            super(suit, rank);
            constructionDetails = "Constructed with suit and rank";
            id = idGenerator.incrementAndGet();
        }

        public String getOuterTitle() {
            return title;
        }

        public String getConstructionDetails() {
            return constructionDetails;
        }

        public int getId() {
            return id;
        }
    }

    public InnerCard getDefaultInnerCard() {
        return new InnerCard();
    }

    public InnerCard getRandomInnerCard() {
        InnerCard randomInnerCard = new InnerCard(
                Card.Suit.values()[ThreadLocalRandom.current().nextInt(4)],
                Card.Rank.values()[ThreadLocalRandom.current().nextInt(14)]
        );
        randomInnerCard.constructionDetails = "Random inner card";
        return randomInnerCard;
    }

    public static void main(String[] args) {

        Card cardOfAnonymousClass = new Card(Card.Suit.HEART, Card.Rank.ACE) {
            private static final AtomicInteger idGenerator = new AtomicInteger(0); // It's ok!
            private static int commonInt = 1;

            private int somewhatInt = 0;

            public int getSomewhatInt() {
                return somewhatInt;
            }

            public void setSomewhatInt(int somewhatInt) {
                this.somewhatInt = somewhatInt;
            }

            public int getCommonInt() {
                return commonInt;
            }
        };

//        cardOfAnonymousClass.getSomewhatInt(); // unreachable method
        System.out.println(cardOfAnonymousClass.getClass());

        class LocalCard extends Card {
            public int getSomewhatInt() {
                return somewhatInt;
            }

            public void setSomewhatInt(int somewhatInt) {
                this.somewhatInt = somewhatInt;
            }

            private int somewhatInt = 0;

            public LocalCard(Suit suit, Rank rank) {
                super(suit, rank);
            }

        }

        LocalCard cardOfLocalClass = new LocalCard(Card.Suit.HEART, Card.Rank.KING);
        cardOfLocalClass.setSomewhatInt(107);
        System.out.println(cardOfLocalClass.getClass());

        Nested nestedA = new Nested("nestedA");
        Nested nestedB = new Nested("nestedB");

        InnerCard innerCardFromA = nestedA.getDefaultInnerCard();
        printInnerCardInfo(innerCardFromA);

        InnerCard innerCardFromB = nestedB.getRandomInnerCard();
        printInnerCardInfo(innerCardFromB);
    }

    private static void printInnerCardInfo(InnerCard innerCard) {
        System.out.println("innerCard: " + innerCard +
                " id:" + innerCard.getId() +
                " outerTitle: " + innerCard.getOuterTitle() +
                " constructionDetails: " + innerCard.getConstructionDetails());
    }
}
