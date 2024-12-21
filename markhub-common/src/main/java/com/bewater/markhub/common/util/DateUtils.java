package com.bewater.markhub.common.util;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther: emp
 * @Date: 2024/12/21 14:08
 * @Description:
 */
@Slf4j
public class DateUtils {

    /**
     * 存储 SimpleDateFormat 实例的线程局部变量缓存，确保线程安全。
     */
    private static final ConcurrentHashMap<String, ThreadLocal<SimpleDateFormat>> formatCache = new ConcurrentHashMap<>();

    /**
     * 默认日期格式模式。
     */
    public final static String DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 默认日期时间格式模式。
     */
    public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 格式化日期对象为字符串。
     * 此方法重载了 format 方法，使用默认的日期格式模式。
     *
     * @param date 日期对象，不能为空
     * @return 以默认日期格式模式格式化后的日期字符串
     * @see #format(Date, String)
     */
    public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    /**
     * 格式化日期对象为字符串。
     * 如果传入的日期对象或格式模式为空，则返回 null。
     * 使用线程局部变量缓存 SimpleDateFormat 实例，确保线程安全并提高性能。
     *
     * @param date   日期对象
     * @param pattern 日期格式模式
     * @return 格式化后的日期字符串
     */
    public static String format(Date date, String pattern) {
        if (date == null || isNullOrEmpty(pattern)) {
            // 如果日期对象或格式模式为空，直接返回 null
            return null;
        }
        try {
            // 使用线程局部变量缓存 SimpleDateFormat 实例，确保线程安全并提高性能
            ThreadLocal<SimpleDateFormat> threadLocalFormat = formatCache.computeIfAbsent(pattern, p -> ThreadLocal.withInitial(() -> new SimpleDateFormat(p)));
            SimpleDateFormat df = threadLocalFormat.get();
            return df.format(date);
        } catch (IllegalArgumentException e) {
            // 记录异常信息，并包含输入参数的上下文信息
            log.error("Error formatting date with pattern '{}': {}", pattern, e.getMessage(), e);
        }
        return null;
    }

    /**
     * 解析日期字符串为日期对象。
     * 如果传入的日期字符串或格式模式为空，则返回 null。
     * 使用线程局部变量缓存 SimpleDateFormat 实例，确保线程安全并提高性能。
     *
     * @param dateStr 日期字符串
     * @param pattern 日期格式模式
     * @return 解析后的日期对象
     */
    public static Date parse(String dateStr, String pattern) {
        if (isNullOrEmpty(dateStr) || isNullOrEmpty(pattern)) {
            // 如果日期字符串或格式模式为空，直接返回 null
            return null;
        }
        try {
            // 使用线程局部变量缓存 SimpleDateFormat 实例，确保线程安全并提高性能
            ThreadLocal<SimpleDateFormat> threadLocalFormat = formatCache.computeIfAbsent(pattern, p -> ThreadLocal.withInitial(() -> new SimpleDateFormat(p)));
            SimpleDateFormat df = threadLocalFormat.get();
            return df.parse(dateStr);
        } catch (ParseException e) {
            // 记录异常信息，并包含输入参数的上下文信息
            log.error("Error parsing date string '{}' with pattern '{}': {}", dateStr, pattern, e.getMessage(), e);
        }
        return null;
    }

    /**
     * 检查字符串是否为空或空字符串。
     *
     * @param str 待检查的字符串
     * @return 如果字符串为空或空字符串，返回 true；否则返回 false
     */
    private static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
