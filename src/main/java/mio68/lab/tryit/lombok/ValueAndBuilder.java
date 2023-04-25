package mio68.lab.tryit.lombok;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.With;

import java.util.Collections;
import java.util.Set;

@Value
@Builder(toBuilder = true)
class Person {

    String name;
    @Singular
    @With
    Set<String> skills;

}


public class ValueAndBuilder {

    public static void main(String[] args) {
        Person jonh = Person.builder()
                .name("John")
                .build();
        System.out.println(jonh);

        Person johnUpgraded = jonh.toBuilder()
                .skill("Java")
                .skill("Spring")
                .build();
        System.out.println(johnUpgraded);

        // This doesn't work
//        Person johnDowngraded = johnUpgraded.toBuilder()
//                .skills(Collections.emptySet())
//                .build();

        Person johnDowngraded = johnUpgraded.toBuilder()
                .build()
                .withSkills(Collections.emptySet());

        System.out.println(johnDowngraded);

        johnDowngraded = johnUpgraded.toBuilder()
                .clearSkills()
                .skills(Set.of("C++"))
                .build();
        System.out.println(johnDowngraded);
    }

}
