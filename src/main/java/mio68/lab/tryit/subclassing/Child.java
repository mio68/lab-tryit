package mio68.lab.tryit.subclassing;

import java.io.IOException;

public class Child extends Parent {

    // It's not possible to protect access to public inherited method.
//    @Override
//    protected void publicMethodOfParent() {
//        super.publicMethodOfParent();
//    }

    // It's OK to give public access to overridden method.
    @Override
    public void protectedMethodOfParent() {
        super.protectedMethodOfParent();
    }

    // It's covariant and so possible to return subclass from the overridden method.
    @Override
    public ReturnValueSubclass getReturnValue() {
        return new ReturnValueSubclass();
    }

    // It's OK to narrow exception list.
    @Override
    public void methodThatThrows() throws IOException {

    }

    // It's not possible to widen throw list. There is no SQLException in the parent method.
//    @Override
//    public void methodThatThrows() throws IOException, SQLException {
//
//    }


}
