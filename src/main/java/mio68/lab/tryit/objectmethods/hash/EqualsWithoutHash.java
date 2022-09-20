package mio68.lab.tryit.objectmethods.hash;

import java.util.HashMap;
import java.util.Map;

public class EqualsWithoutHash {

    private static class PhoneNumber {
        private final int areaCode, prefix, lineNum;

        private PhoneNumber(int areaCode, int prefix, int lineNum) {
            this.areaCode = areaCode;
            this.prefix = prefix;
            this.lineNum = lineNum;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof PhoneNumber other)) {
                return false;
            }

            return areaCode == other.areaCode &&
                    prefix == other.prefix &&
                    lineNum == other.lineNum;
        }
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> phoneBook = new HashMap<>();
        phoneBook.put(new PhoneNumber(913, 828, 2250), "Igor");
        System.out.println(phoneBook.get(new PhoneNumber(913, 828, 2250)));
    }

}
