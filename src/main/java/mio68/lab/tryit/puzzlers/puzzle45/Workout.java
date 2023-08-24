package mio68.lab.tryit.puzzlers.puzzle45;

// I thought it just throws StackOverflowError
// But it prints nothing! Loops indefinitely!
// The most impressive puzzle!
// It perfoms binary tree preordered traversing.
public class Workout {
    public static void main(String[] args) {
        workHard();
        System.out.println("It's nap time.");
    }

    private static void workHard() {
        try {
            workHard();
        } finally {
            workHard();
        }
    }
}
