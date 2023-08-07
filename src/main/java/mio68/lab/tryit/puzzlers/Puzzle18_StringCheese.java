package mio68.lab.tryit.puzzlers;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Puzzle18_StringCheese {
    public static void main(String[] args) throws UnsupportedEncodingException {
        byte [] bytes = new byte[256];
        for (int i = 0; i < 256; i++) {
            bytes[i] = (byte) i;
        }
//        String s = new String(bytes);
        String s = new String(bytes, StandardCharsets.ISO_8859_1);
        System.out.println("s.length() = " + s.length()); // 256
        for (int i = 0, n = s.length(); i < n; i++) {
            System.out.print((int)s.charAt(i) + " "); // from 128 to 256 prints 65533
        }
        System.out.println();
        System.out.println(Integer.toHexString(s.charAt(128)));
        System.out.println(s.charAt(128));
    }
}
