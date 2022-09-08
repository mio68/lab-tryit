package mio68.lab.tryit.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class StarWarsCharacter {

    private final String name;
    private final Species species;
    private final Gender gender;
    private final Homeworld homeworld;
    private final Kind kind;
    private final Integer massInKg;

    public enum Species {
        HUMAN, ZABRAK, GUNGAN, KALEESH
    }

    public enum Homeworld {
        NABOO, TATOOINE, DARTHOMIR, CAMINO, STEWJON, CORUSCANT, KALEE
    }

    public enum Kind {
        JEDI, MANDALORIAN, SITH, BOUNTY_HUNTER, NOBLE, WARLORD
    }

    public enum Gender {
        MALE, FEMALE
    }
}
