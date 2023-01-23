package mio68.lab.tryit.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

//@AllArgsConstructor - Lombok will add private constructor
@Getter
public enum Planet {

    MERCURY(1,"Mercury"),
    VENUS(2,"Venus"),
    EARTH;

    public static final String EARTH_NAME = "Earth";

    Planet(int id, String name) {
        this.id = id;
        this.name = name;
    }

    Planet() {
        id = 3;
        name = EARTH_NAME;
    }

    private String name;
    private int id;


}

enum AEnum {
    ONE, TWO, THREE
}
