package com.cheney.thinker.response.utils;

import org.slf4j.LoggerFactory;

/**
 * description
 * author CheneyThinker
 * date 2018-06-11
 */
public final class LoggerUtils {

    public static void info(Class clazz, String format, Object... args) {
        LoggerFactory.getLogger(clazz).info(format, args);
    }

    public static void error(Class clazz, String format, Object... args) {
        LoggerFactory.getLogger(clazz).error(format, args);
    }

}
