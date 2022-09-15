package mio68.lab.tryit.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericMehtod {

    public static <E extends CharSequence> void doIt(List<E> list) {
        CharSequence charSequence = list.get(0);
        System.out.println("char sequence length: " + charSequence.length());
    }

    public static <E extends CharSequence> List<? super E> getList() {
        return Arrays.asList("Hi", "there");
    }

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Hello!", "World");
        List<StringBuffer> stringBuffers = Arrays.asList(new StringBuffer("Hello"));
        ArrayList<String> strings = new ArrayList<>(stringList);

        doIt(stringList);
        doIt(stringBuffers);
        doIt(strings);

        List rowList = getList();
        System.out.println(rowList.size());

        List<? super CharSequence> listOfCharSequenceSupers = getList();
        System.out.println(listOfCharSequenceSupers.size());

        List<?> listOfUnknows = getList();
        System.out.println(listOfUnknows.size());

//        java: incompatible types: no instance(s) of type variable(s) E exist so that
//        java.util.List<? super E> conforms to java.util.List<java.lang.Object>
//        List<Object> objectList = getList();
    }

}
