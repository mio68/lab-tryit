package mio68.lab.tryit.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.concurrent.TimeUnit;

public class Truncation {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        System.out.println(localDateTime.truncatedTo(ChronoUnit.SECONDS));
        System.out.println(localDateTime.truncatedTo(ChronoUnit.MINUTES));
    }

}
