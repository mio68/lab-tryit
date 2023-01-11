package mio68.lab.tryit.subclassing;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Parent {

    public void publicMethodOfParent() {

    }

    protected void protectedMethodOfParent() {

    }

    public ReturnValue getReturnValue() {
        return new ReturnValue();
    }

    public void methodThatThrows() throws IOException, TimeoutException {

    }
}
