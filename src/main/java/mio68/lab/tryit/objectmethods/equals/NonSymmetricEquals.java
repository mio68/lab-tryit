package mio68.lab.tryit.objectmethods.equals;

import java.util.ArrayList;
import java.util.List;

public class NonSymmetricEquals {

    private static class CaseInsensitiveString {
        private final String s;

        private CaseInsensitiveString(String s) {
            this.s = s;
        }

        @Override
        public int hashCode() {
            return 42;
        }

        @Override
        public boolean equals(Object obj) {

            if (obj instanceof CaseInsensitiveString other) {
                return s.equalsIgnoreCase(other.s);
            }

            if (obj instanceof String other) {
                return s.equalsIgnoreCase(other);
            }

            return false;
        }
    }

    public static void main(String[] args) {
        CaseInsensitiveString cis = new CaseInsensitiveString("Hello");
        String s = "hello";
        CaseInsensitiveString cis2 = new CaseInsensitiveString("hellO");

        EqualContractChecker.printEqualContractInfo(cis, s, cis2);

        List<CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);
        System.out.println("list.add(cis);");
        System.out.println("cis.equals(s): " + cis.equals(s));
        System.out.println("but list.contains(s): " + list.contains(s) + "!!!");

        System.out.println(list.contains(cis2));

    }

}
