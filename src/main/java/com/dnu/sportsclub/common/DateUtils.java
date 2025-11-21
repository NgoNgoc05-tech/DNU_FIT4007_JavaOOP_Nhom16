package main.java.com.dnu.sportsclub.common;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class DateUtils {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(AppConstants.DATE_PATTERN);
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern(AppConstants.DATETIME_PATTERN);

    public static String dateTimeToString(LocalDateTime dateTime) {
        if (dateTime == null) return "N/A";
        return dateTime.format(DATETIME_FORMATTER);
    }
    public static LocalDateTime stringToDateTime(String str) {
        try {
            return LocalDateTime.parse(str, DATETIME_FORMATTER);
        } catch (DateTimeParseException e) {
            System.out.println("Lỗi định dạng ngày tháng! Vui lòng nhập theo dạng: " + AppConstants.DATETIME_PATTERN);
            return null;
        }
    }
    public static String dateToString(LocalDate date) {
        if (date == null) return "N/A";
        return date.format(DATE_FORMATTER);
    }
}