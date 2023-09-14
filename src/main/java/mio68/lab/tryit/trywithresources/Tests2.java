package mio68.lab.tryit.trywithresources;

import mio68.lab.tryit.puzzlers.puzzle60.D;

public class Tests2 {
    public static void main(String[] args) {
        try (Door door = new Door()) {
            door.open();
        } catch (Exception e) {
            System.out.println("[Broken]");
        }
    }
}

class Door implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("[Closed]");
    }

    public void open() {
        System.out.println("[Opened]");
        throw new UnsupportedOperationException();
    }
}