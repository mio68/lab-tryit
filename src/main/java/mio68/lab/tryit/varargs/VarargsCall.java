package mio68.lab.tryit.varargs;

public class VarargsCall {

    public static void callWithArray(String [] strings) {
        System.out.println("callWithArray is invoked");
    }

    public static void callWithVarArg(String... strings) {
        System.out.println("callWithVarArg is invoked");
        for (String s: strings ) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
//        callWithArray("hello", "world", "1"); // Compilation error
        callWithArray(new String[] {"Hello", "World!", "2"}); // Just OK!

        callWithVarArg("Hello", "world", "3"); // Just OK!
        callWithVarArg(new String[] {"Hello", "World!", "4"}); // Just OK too!
        callWithVarArg(); // Just OK again!
    }

}
