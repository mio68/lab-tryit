package mio68.lab.tryit.puzzlers.puzzle60;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BTest {
    private final String INPUT_TEXT = "fear,surprise, ruthless efficiency," +
            "an almost fanatical devotion to the Pope,      nice red uniform";

    private final String[] tokens = {"fear", "surprise", "ruthless efficiency",
            "an almost fanatical devotion to the Pope", "nice red uniform"};

    @Test
    public void parse() {
        assertArrayEquals(tokens, B.parse(INPUT_TEXT));
    }

}