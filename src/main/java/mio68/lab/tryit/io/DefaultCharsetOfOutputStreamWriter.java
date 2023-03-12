package mio68.lab.tryit.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class DefaultCharsetOfOutputStreamWriter {

    public static void main(String[] args) throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream("hello.txt");
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream)) {

            outputStreamWriter.write(outputStreamWriter.getEncoding() + "\n");
            outputStreamWriter.write("Hello World!\n");
            outputStreamWriter.write("Привет Мир!\n");
        }
    }
}
