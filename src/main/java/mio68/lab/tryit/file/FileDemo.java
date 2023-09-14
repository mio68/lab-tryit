package mio68.lab.tryit.file;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        File dir = new File("test");
        dir.mkdir();
        File f = new File(dir, "test.txt");
    }
}
