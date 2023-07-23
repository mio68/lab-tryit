package mio68.lab.tryit.time;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

/* Output
instant epoch milli: 1688809667557
timestamp get time 1688809667557
2023-07-08T09:47:47.557286800Z
2023-07-08 12:47:47.5572868
2023-07-08T09:47:47.557286800Z
2023-07-08 09:47:47.5572868

 */

public class TimeUsingExamples {

    public static void main(String[] args) {
        Instant now = Instant.now();
        Timestamp timestamp = Timestamp.from(now);
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        System.out.println("instant epoch milli: " + now.toEpochMilli());
        System.out.println("timestamp get time " + timestamp.getTime());

        // to string both of them
        System.out.println(now);
        System.out.println(timestamp);
        System.out.println(localDateTime);

        // Change timezone
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));

        // to string again
        System.out.println(now);
        System.out.println(timestamp);
        System.out.println(localDateTime);


        Timestamp timestamp1 = new Timestamp(1672531200000L);
        System.out.println(timestamp1);
        // Change timezone
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Moscow"));
        System.out.println(timestamp1);
    }

}
