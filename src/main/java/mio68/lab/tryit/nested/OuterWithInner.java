package mio68.lab.tryit.nested;

public class OuterWithInner {

    private final String privateNameOfOuter;

    public OuterWithInner(String privateNameOfOuter) {
        this.privateNameOfOuter = privateNameOfOuter;
    }

    public Inner newInnerInstance() {
        return new Inner(); // Outer class can create his inners
    }

    public void method(Inner inner) {
        int r = inner.privateFieldOfInner; //Access to private field of inner.
    }

    public class Inner {

        private static String commonLog = "Inner common log\n";

        private String doLog;
        private int privateFieldOfInner = 0;

        public Inner() {
            // Inner class has access to members of outer class, even to private members
            doLog = "Outer class name:" + privateNameOfOuter + " Inner is ready to work: ";
        }

        public String getDoLog() {
            return doLog;
        }

        public Inner doIt() {
            doLog += " doIt();";
            writeCommonLog(doLog);
            return this;
        }


        private void writeCommonLog(String s) {
                commonLog += this.hashCode() + ": " + s + "\n";
        }

        public String getCommonLog() {
                return commonLog;
        }

        private void method() {
            String s = privateNameOfOuter; // Access to private filed of outer class;
        }
    }

    public static void main(String[] args) {
        OuterWithInner outerWithInner = new OuterWithInner("instanceA");
        OuterWithInner.Inner inner = outerWithInner.new Inner(); // Create inner with enclosing class instance
        System.out.println(inner.doIt().doIt().doIt().getDoLog());
        System.out.println(outerWithInner.newInnerInstance().doIt().getDoLog());
        System.out.println(inner.getCommonLog());
        System.out.println(outerWithInner.newInnerInstance().getCommonLog());

    }
}
