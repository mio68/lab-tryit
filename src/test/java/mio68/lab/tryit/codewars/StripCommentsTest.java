package mio68.lab.tryit.codewars;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StripCommentsTest {

    @Test
    public void stripComments() throws Exception {
        assertEquals(
                "apples, pears\n\ngrapes\n\nbananas",
                StripComments.stripComments( "apples, pears # and bananas \n\ngrapes\n\nbananas  ", new String[] { "#", "!" } )
        );

        assertEquals(
                "a\nc\nd",
                StripComments.stripComments( "a #b\nc\nd $e f g", new String[] { "#", "$" } )
        );

    }

}
