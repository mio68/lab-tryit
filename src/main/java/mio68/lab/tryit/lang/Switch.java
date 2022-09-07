package mio68.lab.tryit.lang;

public class Switch {

    public static void main(String[] args) {
        Type type = null;

        System.out.println( type == Type.A);

//        Exception in thread "main" java.lang.NullPointerException:
//        Cannot invoke "mio68.lab.tryit.lang.Switch$Type.ordinal()" because "type" is null
        switch (type) {
            case A:
                System.out.println(Type.A); return;
            case B:
                System.out.println(Type.B); return;
            default:
                System.out.println(type);

        }

    }

    public enum Type {
        A, B, C
    }

}
