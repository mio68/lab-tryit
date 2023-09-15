package mio68.lab.tryit.annotations;

@Annotation(42)
public class Test {

    @Deprecated
    void hello() {}

    public static void main(String[] args) {
        Test t = new Test();
        t.hello();
    }
}
