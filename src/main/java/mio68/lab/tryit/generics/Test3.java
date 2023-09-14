package mio68.lab.tryit.generics;

public class Test3 {


}


class Outer<T> {

    private T outerField;

    class Inner {
        private T innerField;
    }

//    static class Nested {
//        private T nestedField;
//    }
}