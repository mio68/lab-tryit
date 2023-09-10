package mio68.lab.tryit.statics;


/*

6. ...
    Then, initialize the static fields of C which are constant variable
...
9. Next, execute either the class variable initializers and static initializers of the class, or the field initializers
of the interface, in textual order, as though they were a single block.

 */

public class StaticInit {

    // with static initializer, not clear code ----------------------
    private static final String HI_WORLD;
    static {
        HI_WORLD = "Hi!";
    }

    // preferred way ---------------------------------
    private static final String HI_WORLD_WITH_STATIC_FIELD_INITIALIZER = "HI!";

    // static initializer prohibit forward reference -------
    private static final String HELLO_WORLD;
    // java: illegal forward reference
//    static {
//        HELLO_WORLD = HELLO + WORLD;
//    }
    // Illegal forward reference!
//    private static final String HELLO_ANOTHER_WORLD = HELLO + " " + WORLD;
    private static final String HELLO = "Hello";
    private static final String WORLD = "World";
    // Just OK!
    static {
        HELLO_WORLD = HELLO + " " + WORLD;
    }
    // Just OK again!
    private static final String HELLO_ANOTHER_WORLD = HELLO + " " + WORLD;

    // Initialization with method -------------------
    // Work just fine! Returns "Hello World 2"
    private static final String HELLO_WORLD_2 = hello2();
    // No forward reference at compile time. Initialized fields are used in runtime;
    private static String hello2() {
        return HELLO_2 + " " + WORLD_2 + " 2";
    }
    private static final String HELLO_2 = "Hello";
    private static final String WORLD_2 = "World";

    // Initialization with method can get not initialized fields-------------------
    // Attention! "null null 3" is set to HELLO_WORLD_3
    // Инициализирующий метод может наблюдать константы в не нициализированном состоянии.
    private static final String HELLO_WORLD_3 = hello3();
    private static String hello3() {
        return HELLO_3 + " " + WORLD_3 + " 3";
    }
    private static final String HELLO_3;
    private static final String WORLD_3;
    // Используя static есть риск отложить инициализацию даже для
    // случая константны инициализирующих выражений!!!
    // как правило лучше использовать методы и правильный порядок определения констант.
    static {
        HELLO_3 = "Hello";
        WORLD_3 = "World";
    }

    // It's possible to observe a final static field before it is initilized!
    // Demonstrate that "Final fields are constants only if the initializing expression is a
    // constant expression."
    // Инициализирующий метод может наблюдать константы в не нициализированном состоянии.
    // To fix it START_TIME and START_TIME_PLUS_100 should be reorderd.
    private static final long START_TIME_PLUS_100 = startTimePlus100(); // initialized with value 100
    private static final long START_TIME = System.currentTimeMillis();
    private static long startTimePlus100() {
        return START_TIME + 100;
    }

    // Illegal! variable HELLO_4 not initialized in the default constructor
//    private static final String HELLO_4;

    public static void main(String[] args) {
        System.out.println(HELLO_WORLD_2); // Hello World 2
        System.out.println(HELLO_WORLD_3); // null null 3
        System.out.println(hello3()); // // Hello World 2
        System.out.println(START_TIME);
        System.out.println(START_TIME_PLUS_100); // Prints 100!
    }

}
