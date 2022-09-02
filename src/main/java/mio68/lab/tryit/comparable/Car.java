package mio68.lab.tryit.comparable;

import lombok.ToString;

import java.util.*;

@ToString
public class Car implements Comparable<Car> {

    private static final Comparator<Car> COMPARATOR =
            Comparator.comparing(Car::getManufacturer)
                    .thenComparing(Car::getModel)
                    .thenComparing((Car c) -> c.modification,
                            Comparator.nullsFirst(String::compareTo));

    private final String manufacturer;
    private final String model;
    // modification can be null
    private final String modification;

    public Car(String manufacturer, String model, String modification) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.modification = modification;
    }

    public Car(String manufacturer, String model) {
        this(manufacturer, model, null);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public Optional<String> getModification() {
        return Optional.ofNullable(modification);
    }

    @Override
    public int compareTo(Car o) {
        return COMPARATOR.compare(this, o);
    }

    public static void main(String[] args) {
        List<Car> products = Arrays.asList(
                new Car("Ford","Fiesta"),
                new Car("Toyota","Yaris"),
                new Car("Toyota","Mark2"),
                new Car("Ford","Focus","V2"),
                new Car("Toyota","Camry"),
                new Car("Ford","Focus"),
                new Car("Ford","Focus","V3"),
                new Car("Ford","Focus","V2-restyling"),
                new Car("Toyota","Corolla"),
                new Car("Ford","Mondeo"),
                new Car("Toyota","Avensis"),
                new Car("Toyota","Surf"),
                new Car("Mazda","Demio"));

        Collections.sort(products);

        products.forEach(System.out::println);
    }


}
