package mio68.lab.tryit.heapspace;


import java.util.ArrayList;
import java.util.List;

/*
 Run it with -XX:+HeapDumpOnOutOfMemoryError -Xmx100m
 Memory dump will be created. Look for a file with .hprof extension.

 https://mkyong.com/java/how-to-simulate-java-lang-outofmemoryerror-in-java
 */

public class JavaEatMemory {

    public static void main(String[] args) {

        List<byte[]> list = new ArrayList<>();
        int index = 1;
        while (true) {
            // 1MB each loop, 1 x 1024 x 1024 = 1048576
            byte[] b = new byte[1048576];
            list.add(b);
            Runtime rt = Runtime.getRuntime();
            System.out.printf("[%d] free memory: %s%n", index++, rt.freeMemory());
        }

    }
}