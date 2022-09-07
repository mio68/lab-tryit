package mio68.lab.tryit.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StarWarsCharacter {

    private final String name;
    private final Species species;
    private final Gender gender;
    private final Homeworld homeworld;
    private final Kind kind;
    private final Integer massInKg;

    public enum Species {
        HUMAN, ZABRAK
    }

    public enum Homeworld {
        NABOO, TATOOINE, DARTHOMIR
    }

    public enum Kind {
        JEDI, MANDALORIAN, SITH
    }

    public enum Gender {
        MALE, FEMALE
    }
}
