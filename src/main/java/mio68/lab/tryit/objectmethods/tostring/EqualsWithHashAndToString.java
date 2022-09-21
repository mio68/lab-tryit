package mio68.lab.tryit.objectmethods.tostring;

import java.util.HashMap;
import java.util.Map;

public class EqualsWithHashAndToString {

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

        @Override
        public int hashCode() {
            int result = Integer.hashCode(areaCode);
            result = 31 * result + Integer.hashCode(prefix);
            result = 31 * result + Integer.hashCode(lineNum);
            return result;
        }

        @Override
        public String toString() {
            return String.format("%03d-%03d-%04d",areaCode, prefix, lineNum);
        }
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> phoneBook = new HashMap<>();
        phoneBook.put(new PhoneNumber(913, 828, 2250), "Igor");
        // phoneBook.get() returns "Igor" as expected.
        PhoneNumber phoneNumber = new PhoneNumber(913, 828, 2250);
        System.out.println(phoneBook.get(phoneNumber));
        System.out.println(phoneNumber);
        System.out.println(phoneBook);
    }

}
