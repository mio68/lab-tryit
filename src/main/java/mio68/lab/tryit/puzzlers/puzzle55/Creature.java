package mio68.lab.tryit.puzzlers.puzzle55;

public class Creature {
    public static long numCreated = 0;

    public Creature() {
        numCreated++;
    }

    public static long numCreated() {
        return numCreated;
    }
}
