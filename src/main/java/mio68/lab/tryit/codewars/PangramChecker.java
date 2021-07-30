package mio68.lab.tryit.codewars;

public class PangramChecker {
    public boolean check(String sentence){
        return sentence.codePoints()
                .filter(Character::isAlphabetic)
                .map(Character::toLowerCase)
                .distinct()
                .count() == 26;
    }
}