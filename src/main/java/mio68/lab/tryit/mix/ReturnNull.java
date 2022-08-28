package mio68.lab.tryit.mix;

import java.util.List;
import java.util.Optional;

public class ReturnNull {

    private Integer getWhateverAsNull() {
        return null;
    }

    private Optional<Integer> getWhateverAsOptional() {
        return Optional.empty();
    }

    public static void main(String[] args) {
        ReturnNull returnNull = new ReturnNull();

        Object something = returnNull.getWhateverAsNull();
        String s = (String) something; // It's ok! Null fits any reference type.

        something = returnNull.getWhateverAsOptional();
        s = (String) something; // ClassCastException
    }

}
