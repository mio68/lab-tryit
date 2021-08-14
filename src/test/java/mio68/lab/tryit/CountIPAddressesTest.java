package mio68.lab.tryit;


import mio68.lab.tryit.codewars.CountIPAddresses;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountIPAddressesTest {

    @Test
    public void ipsBetween() throws Exception {
        assertEquals( 50, CountIPAddresses.ipsBetween( "10.0.0.0", "10.0.0.50" ) );
        assertEquals( 246, CountIPAddresses.ipsBetween( "20.0.0.10", "20.0.1.0" ) );
    }

}