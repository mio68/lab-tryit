package mio68.lab.tryit.optionals;

import lombok.Data;

import java.util.Optional;

@Data
public class OptionalFields {

    private int id;
    private String name;

// Got warning from IDEA! Remember - Optional is not Serializable!
//    private Optional<String> alias;
    private String alias;

    // return As Optional
    public Optional<String> getAliasAsOptional() {
        return Optional.ofNullable(alias);
    }

}
