package mio68.lab.tryit.access;

public class OuterWithInners {

    public static final String DESCRIPTION = "Learn access to nested and inner classes";

    public static class PublicNested {

    }

    static class PackagePrivateNested {

    }

    protected static class ProtectedNested {

    }

    private static class PrivateNested {

    }

    public class PublicInner {

    }

    protected class ProtectedInner {
    }

    class PackagePrivateInner {
    }

    private class PrivateInner {
    }

    private void createPrivateInner() {
        PrivateInner privateInner = new PrivateInner();
    }

}
