package mio68.lab.tryit.optionals;

import mio68.lab.tryit.model.Car;
import mio68.lab.tryit.model.Insurance;
import mio68.lab.tryit.model.Person;

import java.util.Optional;

public class ModelTraversing {

    public static void main(String[] args) {

        printInsuranceName(null);

        Person person = new Person();
        printInsuranceName(person);

        Car car = new Car();
        person.setCar(car);
        printInsuranceName(person);

        Insurance insurance = new Insurance();
        car.setInsurance(insurance);
        printInsuranceName(person);

        insurance.setName("TeslaInsurance");
        printInsuranceName(person);
    }

    public static void printInsuranceName(Person person) {
        Optional<Person> optionalPerson = Optional.ofNullable(person);

        //Example how to avoid cascade if-else statements
        System.out.println(
                optionalPerson
                        .map(Person::getCar)
                        .map(Car::getInsurance)
                        .map(Insurance::getName)
                        .orElse("N/A"));
    }

}
