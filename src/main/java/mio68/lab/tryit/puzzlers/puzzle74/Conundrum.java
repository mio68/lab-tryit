package mio68.lab.tryit.puzzlers.puzzle74;

public class Conundrum {
    public static void main(String[] args) {
        Enigma e = new Enigma();
        System.out.println(e.equals(e)); // prints false
    }
}

class Enigma {
    public boolean equals(Enigma e) {
        return false;
    }
}