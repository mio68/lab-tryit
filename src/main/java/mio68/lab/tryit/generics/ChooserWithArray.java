package mio68.lab.tryit.generics;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ChooserWithArray<T> {

    // This field is public to make it possible to get its type by reflection
    public final T[] choices;

    // I am sure that choices contains elements of type T!
    @SuppressWarnings("unchecked")
    public ChooserWithArray(Collection<? extends T> collection) {

        //Let me know choices field type by reflection, before initialization.
        printChoicesTypeInfo();

        // Initialize choices. Take notice that cast (T[]) do nothing at runtime!
        // toArray returns Object[] so we need to cast to imply that this array contains elements of type T
        choices = (T[]) collection.toArray();

        // What is actual class of choices at runtime?
        System.out.println("At runtime field 'choices' is " + choices.getClass());

        // What is actual class of choices elements at runtime?
        System.out.println("First element from 'choices' is " + choices[0].getClass());
    }

    public T get() {
        Random rnd = ThreadLocalRandom.current();
        return choices[rnd.nextInt(choices.length)];
    }

    private void printChoicesTypeInfo() {
        try {
            System.out.println(
                    "Field 'choices' type by reflection is " +
                            getClass().getField("choices").getType());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChooserWithArray<String> chooser = new ChooserWithArray<>(
                Arrays.asList("Phuket", "Koh Samui", "Koh Chang"));

        // Make your choice!
        String choice = chooser.get(); // It's a String! No need to cast!
        System.out.println("Random choice is " + choice);
    }

}
