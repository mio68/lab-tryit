package mio68.lab.tryit.access.otherpackage;

import mio68.lab.tryit.access.OuterWithInners;

public class ClientOfOuterWithInners {

    public static void main(String[] args) {
        OuterWithInners outerWithInners = new OuterWithInners();

        /* The other nested classes are not accessible */
        OuterWithInners.PublicNested publicNested = new OuterWithInners.PublicNested();

        /* The other inner classes are not accessible */
        OuterWithInners.PublicInner publicInner = outerWithInners.new PublicInner();

    }
}
