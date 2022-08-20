package mio68.lab.tryit.concurrency.trywithresources;

public class TryWithResourcesTest {

    public static void main(String[] args) {

        example1();

        try {
            example2();
        } catch (ClosingException e) {
            System.out.println("example 2 call failed");
            e.printStackTrace(System.out);
        }

        try {
            example3();
        } catch (Exception e) {
            System.out.println("example 3 call failed");
            e.printStackTrace(System.out);
        }

        try {
            example4();
        } catch (Exception e) {
            System.out.println("example 4 call failed");
            e.printStackTrace(System.out);
        }

        try {
            example5();
        } catch (Exception e) {
            System.out.println("example 5 call failed");
            e.printStackTrace(System.out);
        }

        try {
            example6();
        } catch (Exception e) {
            System.out.println("example 6 call failed");
            e.printStackTrace(System.out);
        }

    }

    /**
     * Catch close execption of AutoCloseable resource.
     */
    public static void example1() {
        try (ResourceA resourceA = new ResourceA()) {
            System.out.println("try block of example 1");
        } catch (ClosingException e) {
            System.out.println("catch block of example 1");
            e.printStackTrace(System.out);
        }
    }

    /**
     * Example throws exception from close method of AutoCloseable resource
     * @throws ClosingException for resource
     */
    public static void example2() throws ClosingException {
        try (ResourceA resourceA = new ResourceA()) {
            System.out.println("try block of example 2");
        }
    }

    /**
     * Example throws ProcessingException from try block,
     * and ClosingException thrown from close method of resource is suppressed.
     * @throws ClosingException
     * @throws ProcessingException
     */
    public static void example3() throws ClosingException, ProcessingException {
        try (ResourceA resourceA = new ResourceA()) {
            System.out.println("try block of example 3");
            throw new ProcessingException("example 3 failed");
        }
    }

    /**
     * Both resources throw exceptions at close method.
     * As a result example4() throws ClosingException for resource B and the second exception
     * from resource A is suppressed.
     * @throws ClosingException
     */
    public static void example4() throws ClosingException {
        try (ResourceA resourceA = new ResourceA();
             ResourceB resourceB = new ResourceB()) {
            System.out.println("try block of example 4");
        }
    }

    /**
     * Try block throws ProcessingException and both resources throw exceptions
     * at close method.
     * As a result example5() throws ProcessingException and
     * ClosingException for resource B is suppressed and the second exception
     * from resource A is suppressed too.
     * @throws ClosingException, ProcessingException
     */
    public static void example5() throws ClosingException, ProcessingException {
        try (ResourceA resourceA = new ResourceA();
             ResourceB resourceB = new ResourceB()) {
            System.out.println("try block of example 5");
            throw new ProcessingException("example 5 failed");
        }
    }

    /**
     * Try block throws ProcessingException and resources A throw exception
     * at close method, and resource B is null.
     * As a result example6() throws ProcessingException
     * and the ClosingException from resource A is suppressed.
     * NPE for resource B is not thrown, try-with-resources doesn't call close on
     * NULLs.)
     * @throws ClosingException
     */
    public static void example6() throws ClosingException, ProcessingException {
        try (ResourceA resourceA = new ResourceA();
             ResourceB resourceB = createResourceB()) {
            System.out.println("try block of example 6");
            throw new ProcessingException("example 6 failed");
        }
    }

    public static class ResourceA implements AutoCloseable {

        @Override
        public void close() throws ClosingException {
            throw new ClosingException(getClass().getName()+".close() failed.");
        }
    }

    public static class ResourceB implements AutoCloseable {

        @Override
        public void close() throws ClosingException {
            throw new ClosingException(getClass().getName()+".close() failed.");
        }
    }

    public static ResourceB createResourceB() {
        return null;
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
