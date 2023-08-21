package mio68.lab.tryit.puzzlers.puzzle44;
// Both classes Strange1 and Strange2 behaves in the same manner -
// They print "Got it" if Missing.class is missing.
// Don't rely on NoClassDefFoundError!
// Moreover, never catch Errors at all!
public class Strange1 {
    public static void main(String[] args) {
        try {
            Missing m = new Missing();
        } catch (NoClassDefFoundError ex) {
            System.out.println("Got it!");
        }
    }
}
