package mio68.lab.tryit.Strings;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;



/*
Char literal - \\uxxxx. Here xxxx represents 4 hexadecimal numbers.
Note: wihout duobled backslash \\uxxxx is illegal unicode escape

UTF-8 encoding
'\u0000' to '\u007F' - one byte - 0xxxxxxx - 7 bits
'\u0080' to '\u07FF' - two bytes - 110xxxxx, 10xxxxxx - total 11 bits
'\u0800' to '\uFFFF' - three bytes - 1110xxxx, 10xxxxxx, 10xxxxxx - total 16 bits

 The first 128 characters of Unicode, which correspond one-to-one with ASCII,
 are encoded using a single byte with the same binary value as ASCII,
 so that valid ASCII text is valid UTF-8-encoded Unicode as well.
 */


public class CharsAndBytesUtf8 {

    public static void main(String[] args) {
        String s = "a";
        System.out.println(Arrays.toString(s.getBytes(StandardCharsets.UTF_8))); // prints [97]

        char[] chars = new char[] {'\u0097'};
        // '\u0097' in range '\u0080' to '\u07FF' -> 2 bytes
        // 0x97 -> 0b10010111
        // 0b11000010, 0b10010111 -> -62, -105
        String str = new String(chars);
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8); // UTF-8 uses one to four one-byte (8-bit) code units
        System.out.println(Arrays.toString(bytes)); // prints [-62, -105]

        System.out.println(Arrays.toString(String.valueOf('\u007F').getBytes(StandardCharsets.UTF_8))); // [127]
        System.out.println(Arrays.toString(String.valueOf('\u07FF').getBytes(StandardCharsets.UTF_8))); // [-33, -65]
        System.out.println(Arrays.toString(String.valueOf('\uFFFF').getBytes(StandardCharsets.UTF_8))); // [-17, -65, -65]

    }
}
