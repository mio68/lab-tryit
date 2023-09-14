package mio68.lab.tryit.annotations;

import java.util.Objects;

public class Test3 {
    public static void main(String[] args) throws NoSuchFieldException {
//        String field = Clazz.class.getDeclaredField("field").getAnnotation(JsonElement.class).key2();
//        System.out.println(field);

//        String field = ((JsonElement) (Clazz.class.getDeclaredField("field"))).key2();
//        System.out.println(field);
    }
}


@interface JsonElement {
    String key2() default "";
}

class Clazz {
    @JsonElement(key2 = "hi!")
    private Object field;
}