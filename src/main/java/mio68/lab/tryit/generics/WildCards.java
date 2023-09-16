package mio68.lab.tryit.generics;

import java.util.ArrayList;
import java.util.List;

/*
Java предоставляет особый вид параметризованного типа, именуемый ограниченным типом
с символами подстановки (bounded wildcard type)

Для максимальной гибкости для входных параметров,
представляющих производителей или потребителей, следует использовать
типы с символами подстановки.

PECS — producer-extends, consumer-super
(производитель — extends, потребитель — super)

 */

public class WildCards {

    public static void main(String[] args) {

        // ? extends -------------------------------------------
        List<? extends Number> numExts = null; // It's produces subclasses of Number.
                                        // It's not possible to put anything to it!
        List<Integer> integers = new ArrayList<>(List.of(1,2,3));

//        integers = numExts; // It' incorrect!
//        List<Object> objs = numExts; // wildcard parametrized can'b assigned to parametrized
        List lst = numExts; // It's only possible assigment
        lst = integers; // it's ok
        numExts = integers; // It's OK! numExts produces subclasses of Numbers,
                            // and integers suits this case!
        System.out.println( numExts.get(0)); // prints 1
        Number aNum = numExts.get(1); // Compilation is Ok, so Runtime will be OK too, I think)

//        numExts.add(new Object()); // compilation error
//        numExts.add(Integer.valueOf(1)); // compilation error

        // ? super -------------------------------------
        List<? super Integer> intSupers = null; // Consumes an unknown class that is super classes of Integer,
        // so you can add only Integers to collection.
        // Lists that are able to write Integers are List<Object>, List<Number>, List<Integer>
        // The only class than you can safely read from them is Object.

//        integers = intSupers; // Not compatible! integers reads/writes exact integers!
//        but from intSupers you can read Objects only.
//        List<Object> objects = intSupers; // wildcard parametrized type as returned value - bad idea!
          List list = intSupers; // Possible

        intSupers = integers;
        intSupers.add(1);
//        intSupers.add(aNum); // compilation error. intSupers maybe a reference to List<Integer>!
//        aNum = intSupers.get(1); // compilation error.
         Object anObj = intSupers.get(1); // It's just OK!

    }

}
