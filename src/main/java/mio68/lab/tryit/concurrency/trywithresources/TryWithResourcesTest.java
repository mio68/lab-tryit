package mio68.lab.tryit.concurrency.trywithresources;

public class TryWithResourcesTest {

    public static void main(String[] args) {

        example1();

        try {
            example2();
        } catch (ClosingException e) {
            System.out.println("example 2 call failed");
            e.printStackTrace();
        }

        try {
            example3();
        } catch (Exception e) {
            System.out.println("example 3 call failed");
            e.printStackTrace();
        }

    }

    public static void example1() {
        try (ResourceA resourceA = new ResourceA()) {
            System.out.println("try block of example 1");
        } catch (ClosingException e) {
            System.out.println("catch block of example 1");
            e.printStackTrace();
        }
    }

    public static void example2() throws ClosingException {
        try (ResourceA resourceA = new ResourceA()) {
            System.out.println("try block of example 2");
        }
    }

    public static void example3() throws ClosingException, ProcessingException {
        try (ResourceA resourceA = new ResourceA()) {
            System.out.println("try block of example 3");
            throw new ProcessingException("example 3 failed");
        }
    }

    public static class ResourceA implements AutoCloseable {

        @Override
        public void close() throws ClosingException {
            throw new ClosingException(getClass().getName()+".close() failed.");
        }
    }

    public static class ClosingException extends Exception {
        public ClosingException(String message) {
            super(message);
        }
    }

    public static class ProcessingException extends Exception {
        public ProcessingException(String message) {
            super(message);
        }
    }
}
