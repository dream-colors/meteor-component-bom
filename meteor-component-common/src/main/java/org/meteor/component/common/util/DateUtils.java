package org.meteor.component.common.util;

import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * @author meteor
 * @date 2022/10/16 14:01
 */
public abstract class DateUtils {
    public static final Pattern REGEX_NORM = Pattern.compile("\\d{4}-\\d{1,2}-\\d{1,2}(\\s\\d{1,2}:\\d{1,2}(:\\d{1,2})?)?(.\\d{1,6})?");

    public static final String NORM_YEAR_PATTERN = "yyyy";

    public static final String NORM_MONTH_PATTERN = "yyyy-MM";
    public static final DateTimeFormatter NORM_MONTH_FORMATTER = createFormatter(NORM_MONTH_PATTERN);

    public static final String SIMPLE_MONTH_PATTERN = "yyyyMM";
    public static final DateTimeFormatter SIMPLE_MONTH_FORMATTER = createFormatter(SIMPLE_MONTH_PATTERN);

    public static final String NORM_DATE_PATTERN = "yyyy-MM-dd";
    public static final DateTimeFormatter NORM_DATE_FORMATTER = createFormatter(NORM_DATE_PATTERN);

    public static final String NORM_TIME_PATTERN = "HH:mm:ss";
    public static final DateTimeFormatter NORM_TIME_FORMATTER = createFormatter(NORM_TIME_PATTERN);

    public static final String NORM_DATETIME_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
    public static final DateTimeFormatter NORM_DATETIME_MINUTE_FORMATTER = createFormatter(NORM_DATETIME_MINUTE_PATTERN);

    public static final String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final DateTimeFormatter NORM_DATETIME_FORMATTER = createFormatter(NORM_DATETIME_PATTERN);

    public static final String NORM_DATETIME_MS_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final DateTimeFormatter NORM_DATETIME_MS_FORMATTER = createFormatter(NORM_DATETIME_MS_PATTERN);

    public static final String ISO8601_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS";
    public static final DateTimeFormatter ISO8601_FORMATTER = createFormatter(ISO8601_PATTERN);

    public static final String CHINESE_DATE_PATTERN = "yyyy年MM月dd日";
    public static final DateTimeFormatter CHINESE_DATE_FORMATTER = createFormatter(CHINESE_DATE_PATTERN);

    public static final String CHINESE_DATE_TIME_PATTERN = "yyyy年MM月dd日HH时mm分ss秒";
    public static final DateTimeFormatter CHINESE_DATE_TIME_FORMATTER = createFormatter(CHINESE_DATE_TIME_PATTERN);

    public static final String PURE_DATE_PATTERN = "yyyyMMdd";
    public static final DateTimeFormatter PURE_DATE_FORMATTER = createFormatter(PURE_DATE_PATTERN);

    public static final String PURE_TIME_PATTERN = "HHmmss";
    public static final DateTimeFormatter PURE_TIME_FORMATTER = createFormatter(PURE_TIME_PATTERN);

    public static final String PURE_DATETIME_PATTERN = "yyyyMMddHHmmss";
    public static final DateTimeFormatter PURE_DATETIME_FORMATTER = createFormatter(PURE_DATETIME_PATTERN);

    public static final String PURE_DATETIME_MS_PATTERN = "yyyyMMddHHmmssSSS";
    public static final DateTimeFormatter PURE_DATETIME_MS_FORMATTER = createFormatter(PURE_DATETIME_MS_PATTERN);

    private DateUtils() {
    }

    public static DateTimeFormatter createFormatter(String pattern) {
        return DateTimeFormatter.ofPattern(pattern, Locale.getDefault()).withZone(ZoneId.systemDefault());
    }

    public static String format(LocalDateTime dateTime) {
        if (dateTime == null) {
            throw new IllegalArgumentException("dateTime can not be null");
        }
        return NORM_DATETIME_FORMATTER.format(dateTime);
    }

    public static String formatNow() {
        return NORM_DATETIME_FORMATTER.format(LocalDateTime.now());
    }

    public static LocalDateTime toLocalDateTime(String dateTime) {
        if (!StringUtils.hasText(dateTime) || !REGEX_NORM.matcher(dateTime).matches()) {
            throw new IllegalArgumentException("Invalid dateTime: " + dateTime);
        }
        return LocalDateTime.parse(dateTime, NORM_DATE_FORMATTER);
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date can not be null");
        }
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static LocalDateTime toLocalDateTime(String dateTime, DateTimeFormatter formatter) {
        if (!StringUtils.hasText(dateTime) || !REGEX_NORM.matcher(dateTime).matches()) {
            throw new IllegalArgumentException("Invalid dateTime: " + dateTime);
        }
        if (formatter == null) {
            throw new IllegalArgumentException("formatter can not be null");
        }
        return LocalDateTime.parse(dateTime, formatter);
    }

    public static LocalDate toLocalDate(String date) {
        if (!StringUtils.hasText(date) || !REGEX_NORM.matcher(date).matches()) {
            throw new IllegalArgumentException("Invalid dateTime: " + date);
        }
        return LocalDate.parse(date, NORM_DATE_FORMATTER);
    }

    public static LocalDate toLocalDate(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date can not be null");
        }
        return toLocalDateTime(date).toLocalDate();
    }

    public static LocalDate toLocalDate(String date, DateTimeFormatter formatter) {
        if (!StringUtils.hasText(date) || !REGEX_NORM.matcher(date).matches()) {
            throw new IllegalArgumentException("Invalid dateTime: " + date);
        }
        if (formatter == null) {
            throw new IllegalArgumentException("formatter can not be null");
        }
        return LocalDate.parse(date, formatter);
    }

    public static LocalTime toLocalTime(String time) {
        if (!StringUtils.hasText(time) || !REGEX_NORM.matcher(time).matches()) {
            throw new IllegalArgumentException("Invalid dateTime: " + time);
        }
        return LocalTime.parse(time, NORM_DATE_FORMATTER);
    }

    public static LocalTime toLocalTime(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("Date can not be null");
        }
        return toLocalDateTime(date).toLocalTime();
    }

    public static LocalTime toLocalTime(String time, DateTimeFormatter formatter) {
        if (!StringUtils.hasText(time) || !REGEX_NORM.matcher(time).matches()) {
            throw new IllegalArgumentException("Invalid dateTime: " + time);
        }
        if (formatter == null) {
            throw new IllegalArgumentException("formatter can not be null");
        }
        return LocalTime.parse(time, formatter);
    }

}
