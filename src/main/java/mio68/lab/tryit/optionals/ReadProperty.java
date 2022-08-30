package mio68.lab.tryit.optionals;

import java.util.Optional;
import java.util.Properties;

public class ReadProperty {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        System.out.println(readDuration(props, "a"));
        System.out.println(readDuration(props, "b"));
        System.out.println(readDuration(props, "c"));
        System.out.println(readDuration(props, "d"));


    }


    public static int readDuration(Properties prop, String name) {
        return Optional.ofNullable(prop.getProperty(name))
                .map(s -> {
                    try {
                        return Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        return 0;
                    }
                })
                .filter(integer -> integer > 0)
                .orElse(0);

    }
}
