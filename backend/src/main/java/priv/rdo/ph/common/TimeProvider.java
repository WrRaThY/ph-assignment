package priv.rdo.ph.common;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeProvider {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static Clock clock = Clock.systemDefaultZone();

    private TimeProvider() {
    }

    /**
     * might be useful for testing purposes
     */
    public static void setClock(Clock clock) {
        TimeProvider.clock = clock;
    }

    public static String nowAsString() {
        return now().format(formatter);
    }

    public static String nowAsStringPlusMinutes(long minutes) {
        return now().plusMinutes(minutes).format(formatter);
    }

    public static LocalDateTime now() {
        return LocalDateTime.now(clock);
    }
}
