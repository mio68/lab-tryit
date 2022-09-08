package mio68.lab.tryit.model;

import java.util.ArrayList;
import java.util.List;

import static mio68.lab.tryit.model.StarWarsCharacter.Gender.FEMALE;
import static mio68.lab.tryit.model.StarWarsCharacter.Gender.MALE;
import static mio68.lab.tryit.model.StarWarsCharacter.Homeworld.*;
import static mio68.lab.tryit.model.StarWarsCharacter.Kind.*;
import static mio68.lab.tryit.model.StarWarsCharacter.Species.*;

public class StarWarsCharacters {

    private static final List<StarWarsCharacter> starWarsCharacters = new ArrayList<>(100);

    static {
        starWarsCharacters.add(StarWarsCharacter.builder().name("Luke Skywalker").homeworld(TATOOINE).species(HUMAN).gender(MALE).kind(JEDI).massInKg(73).build());
        starWarsCharacters.add(StarWarsCharacter.builder().name("Obi-Wan Kenobi").homeworld(STEWJON).species(HUMAN).gender(MALE).kind(JEDI).massInKg(81).build());
        starWarsCharacters.add(StarWarsCharacter.builder().name("Qui-Gon Jinn").homeworld(CORUSCANT).species(HUMAN).gender(MALE).kind(JEDI).build());
        starWarsCharacters.add(StarWarsCharacter.builder().name("Darth Vader").homeworld(TATOOINE).species(HUMAN).gender(MALE).kind(SITH).massInKg(120).build());
        starWarsCharacters.add(StarWarsCharacter.builder().name("Darth Sidious").homeworld(NABOO).species(HUMAN).gender(MALE).kind(SITH).massInKg(75).build());
        starWarsCharacters.add(StarWarsCharacter.builder().name("Padmé Amidala").homeworld(NABOO).species(HUMAN).gender(FEMALE).build());
        starWarsCharacters.add(StarWarsCharacter.builder().name("Jar Jar Binks").homeworld(NABOO).species(GUNGAN).gender(MALE).massInKg(70).build());
        starWarsCharacters.add(StarWarsCharacter.builder().name("Darth Maul").homeworld(DARTHOMIR).species(ZABRAK).gender(MALE).kind(SITH).build());
        starWarsCharacters.add(StarWarsCharacter.builder().name("Yoda").gender(MALE).kind(JEDI).massInKg(13).build());
        starWarsCharacters.add(StarWarsCharacter.builder().name("Boba Fett").homeworld(CAMINO).species(HUMAN).gender(MALE).kind(BOUNTY_HUNTER).massInKg(78).build());
        starWarsCharacters.add(StarWarsCharacter.builder().name("Grievous").homeworld(KALEE).species(KALEESH).gender(MALE).kind(WARLORD).massInKg(159).build());

    }

    public static List<StarWarsCharacter> getList() {
        return new ArrayList<>(starWarsCharacters);
    }
}
