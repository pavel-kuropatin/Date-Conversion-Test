package by.kurapatsin.dateconversiontest.util;

import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class DateUtils {

    public static final ZoneId MINSK_ZONE_ID = ZoneId.of("Europe/Minsk");
    public static final ZoneId UTC_ZONE_ID = ZoneId.of(ZoneOffset.UTC.getId());
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    public static final DateTimeFormatter DESERIALIZATION_ISO_DATE_FORMATTER = DateTimeFormatter.ISO_DATE;
    public static final DateTimeFormatter DESERIALIZATION_ISO_DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;
    public static final DateTimeFormatter SERIALIZATION_ISO_DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
    public static final DateTimeFormatter SERIALIZATION_ISO_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN);
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat(DATE_PATTERN);
    public static final SimpleDateFormat SIMPLE_DATE_TIME_FORMAT = new SimpleDateFormat(DATE_TIME_PATTERN);
}
