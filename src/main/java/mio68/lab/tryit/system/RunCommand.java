package mio68.lab.tryit.system;

import java.io.IOException;

public class RunCommand {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        Process exec = runtime.exec("java -version");
        int exitCode = exec.waitFor();
        System.out.println(exitCode);
    }
}
