package com.dnu.sportsclub.common;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(AppConstants.DATE_PATTERN);

    public static String toString(LocalDateTime date) {
        return date != null ? date.format(FORMATTER) : "N/A";
    }

    // Hàm tiện ích tạo ngày giờ nhanh để test
    public static LocalDateTime nowPlusHours(int hours) {
        return LocalDateTime.now().plusHours(hours);
    }
}