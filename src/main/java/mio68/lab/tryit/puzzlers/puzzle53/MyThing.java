package mio68.lab.tryit.puzzlers.puzzle53;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyThing extends Thing {

    private final int arg;

    public MyThing() {
        this(SomeOtherClass.func());
    }

    private MyThing(int arg) {
        super(arg);
        this.arg = arg;
        log.info("arg = {}", arg);
    }

//    private static ThreadLocal<Integer> integerThreadLocal = new ThreadLocal<>();
//
//    private final int arg;
//
//    public MyThing() {
//        super(createArg());
//        arg = integerThreadLocal.get();
//        log.info("arg = {}", arg);
//    }
//
//    private static int createArg() {
//        integerThreadLocal.set(SomeOtherClass.func());
//        return integerThreadLocal.get();
//    }

    public static void main(String[] args) {
        MyThing myThing = new MyThing();
        myThing = new MyThing();
        myThing = new MyThing();
    }

}
