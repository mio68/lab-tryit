package mio68.lab.tryit.puzzlers.puzzle43;

import java.io.IOException;

public class TigerThrower<T extends Throwable> {

    public static void sneakyThrow(Throwable t) {
        new TigerThrower<Error>().sneakyThrow2(t);
    }

    @SuppressWarnings("unchecked")
    private void sneakyThrow2(Throwable t) throws T {
        throw (T) t;
    }


    public static void main(String[] args) {
        try {
//            sneakyThrow(new Throwable("Throw a throwable"));
//            sneakyThrow(new Error("Throw a error"));
//            sneakyThrow(new RuntimeException("Throw a runtime error"));
//            sneakyThrow(new Exception("Throw an exception"));

            IOException ioException = new IOException("New IO exception");
            sneakyThrow(ioException);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
