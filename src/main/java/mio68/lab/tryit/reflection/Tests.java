package mio68.lab.tryit.reflection;

import java.util.Arrays;
import java.util.regex.Matcher;

public class Tests {
    public static void main(String[] args) {
        Arrays.stream(Holder.class.getConstructors())
                .forEach(System.out::println);
    }
}

class Holder {

    public long value;

    public Holder(long value) {
        this.value = value;
    }

    protected Holder(double value) {
        this.value = Math.round(value);
    }

    private Holder() {
        this.value = 42;
    }
}