package utils;

import java.time.LocalDateTime;
import java.time.Month;

public class DateUtils {

    public static int getCurrentYear() {
        return LocalDateTime.now().getYear();
    }

    public static Month getCurrentMonth() {
        return LocalDateTime.now().getMonth();
    }

    public static int getCurrentDay() {
        return LocalDateTime.now().getDayOfMonth();
    }
}
