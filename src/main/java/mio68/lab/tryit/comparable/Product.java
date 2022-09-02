package mio68.lab.tryit.comparable;

import lombok.ToString;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@ToString
public class Product implements Comparable<Product> {

    private static final Comparator<String> MODIFICATION_COMPARATOR =
            Comparator.nullsFirst(String::compareTo);

    private final String manufacturer;
    private final String model;
    // modification can be null
    private final String modification;


    public Product(String manufacturer, String model, String modification) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.modification = modification;
    }

    public Product(String manufacturer, String model) {
        this(manufacturer, model, null);
    }

    @Override
    public int compareTo(Product o) {
        int result = manufacturer.compareTo(o.manufacturer);
        if (result == 0) {
            result = model.compareTo(o.model);
            if (result == 0) {
                result = MODIFICATION_COMPARATOR.compare(
                        modification,
                        o.modification);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Ford","Fiesta"),
                new Product("Toyota","Yaris"),
                new Product("Toyota","Mark2"),
                new Product("Ford","Focus","V2"),
                new Product("Toyota","Camry"),
                new Product("Ford","Focus"),
                new Product("Ford","Focus","V3"),
                new Product("Ford","Focus","V2-restyling"),
                new Product("Toyota","Corolla"),
                new Product("Ford","Mondeo"),
                new Product("Toyota","Avensis"),
                new Product("Toyota","Surf"),
                new Product("Mazda","Demio"));

        Collections.sort(products);

        products.forEach(System.out::println);
    }


}
