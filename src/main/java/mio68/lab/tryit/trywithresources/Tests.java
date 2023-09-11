package mio68.lab.tryit.trywithresources;

import java.io.Closeable;
import java.io.IOException;

public class Tests {

    public static void main(String[] args) throws Exception {

        try (MyCloseable resource1 = new MyCloseable();
             MyAutoCloseable resource2 = new MyAutoCloseable()) {

        }

    }

    static class MyCloseable implements Closeable {

        @Override
        public void close() throws IOException {

        }
    }

    static class MyAutoCloseable implements AutoCloseable {

        @Override
        public void close() throws Exception {

        }
    }

}
