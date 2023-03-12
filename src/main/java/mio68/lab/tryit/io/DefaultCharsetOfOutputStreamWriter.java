package mio68.lab.tryit.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

// The charset that it uses may be specified by name or may be given explicitly,
// or the platform's default charset may be accepted.

public class DefaultCharsetOfOutputStreamWriter {

    public static void main(String[] args) throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream("hello.txt");
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream)) {

            System.out.printf("Default charset of this Java virtual machine: [%s]%n", Charset.defaultCharset());
            System.out.printf("Default encoding for OutputStreamWriter: [%s]%n", outputStreamWriter.getEncoding());

            outputStreamWriter.write("Hello World!\n");
            outputStreamWriter.write("Привет Мир!\n");
        }
    }
}
