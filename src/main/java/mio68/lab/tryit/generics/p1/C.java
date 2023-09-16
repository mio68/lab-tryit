package mio68.lab.tryit.generics.p1;

public class C<T> implements Box<T>{

    @Override
    public T getT() {
        return null;
    }

    public static void main(String[] args) {
        C<String> c = new C<>();
        String s = c.getT();
    }

}
