package mio68.lab.tryit.mix;

public class PrimitiveTypeToken {

    public static void main(String[] args) {
        Class<Integer> intClass =  int.class;
        Class<Integer> integerClass = Integer.class;

        System.out.println(intClass);
        System.out.println(integerClass);
        System.out.println(intClass.equals(integerClass));
//        Output:
//        int
//        class java.lang.Integer
//        false
    }
}
