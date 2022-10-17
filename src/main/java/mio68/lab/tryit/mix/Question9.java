package mio68.lab.tryit.mix;

class Super {
    static String ID = "QBANK";
}

class Sub extends Super {
    static String SUB_ID = "SUB_QBANK";

    static {
        System.out.print("In Sub");
    }
}

// It prints
//QBANK
// Class Sub isn't loaded because it fields or method are not accessed.
class Question9 {
    public static void main(String[] args) {
        System.out.println(Sub.ID);
//        System.out.println(Sub.SUB_ID);
    }
}