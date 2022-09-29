import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class LocalTimeMethods {
    public static String formatTime(LocalTime endTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return endTime.format(formatter);
    }
    public static long calculateDuration(LocalTime start,LocalTime end){
        return start.until(end,ChronoUnit.HOURS);
    }
}
