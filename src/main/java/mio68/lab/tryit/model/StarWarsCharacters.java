package mio68.lab.tryit.model;

import java.util.ArrayList;
import java.util.List;

import static mio68.lab.tryit.model.StarWarsCharacter.Gender.MALE;
import static mio68.lab.tryit.model.StarWarsCharacter.Homeworld.*;
import static mio68.lab.tryit.model.StarWarsCharacter.Kind.JEDI;
import static mio68.lab.tryit.model.StarWarsCharacter.Kind.SITH;
import static mio68.lab.tryit.model.StarWarsCharacter.Species.HUMAN;
import static mio68.lab.tryit.model.StarWarsCharacter.Species.ZABRAK;

public class StarWarsCharacters {

    private static List<StarWarsCharacter> starWarsCharacters = new ArrayList<>(100);

    static {
        starWarsCharacters.add(StarWarsCharacter.builder().name("Luke Skywalker").homeworld(TATOOINE).species(HUMAN).gender(MALE).kind(JEDI).massInKg(73).build());
        starWarsCharacters.add(StarWarsCharacter.builder().name("Darth Sidious").homeworld(NABOO).species(HUMAN).gender(MALE).kind(SITH).massInKg(75).build());
        starWarsCharacters.add(StarWarsCharacter.builder().name("Darth Maul").homeworld(DARTHOMIR).species(ZABRAK).gender(MALE).kind(SITH).build());
        starWarsCharacters.add(StarWarsCharacter.builder().name("Yoda").gender(MALE).kind(JEDI).massInKg(13).build());

    }

    public static List<StarWarsCharacter> getList() {
        return new ArrayList<>(starWarsCharacters);
    }
}
