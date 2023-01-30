package mio68.lab.tryit.enums;

public class SwitchWitEnum {

    private enum Type {
        ONE, TWO, THREE
    }

    private enum Num {
        ONE, TWO, THREE
    }

    public static void main(String[] args) {

        Type type = Type.valueOf(args[0]);
        switch (type) {
            case ONE, TWO -> System.out.println(type);
            default -> System.out.println("default");
        }

        Num num = Num.valueOf(args [1]);
        switch (num) {
            case ONE, TWO -> System.out.println(type);
//            case Type.ONE -> System.out.println("is it possible?"); // Compilation error!
            default -> System.out.println("default");
        }

        // Compilation is Ok, but IDEA warns about it!
        // 'switch' statement has too few case labels (1), and should probably be replaced with an 'if' statement
        switch (num) {
            case ONE -> System.out.println(type);
        }

    }

}
