package mio68.lab.tryit.puzzlers.puzzle60;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ATest {

    private final List<String> source = List.of("spam", "sausage", "spam", "spam",
            "bacon", "spam", "tomato", "spam");
    private final List<String> deduplicated = List.of("spam", "sausage", "bacon", "tomato");

    @Test
    public void removeDuplicates() {
        assertIterableEquals(deduplicated, A.removeDuplicates(source));
    }

    @Test
    public void removeDuplicates2() {
        assertIterableEquals(deduplicated, A.removeDuplicates2(source));
    }


}