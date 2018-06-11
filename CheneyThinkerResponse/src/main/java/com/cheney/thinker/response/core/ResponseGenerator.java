package com.cheney.thinker.response.core;

import com.cheney.thinker.response.utils.LoggerUtils;
import org.springframework.util.StringUtils;

/**
 * @description 响应结果生成器
 * @author CheneyThinker
 * @date 2018-06-11
 */
public final class ResponseGenerator {

    private static final String DEFAULT_OK = "OK";
    private static final String format = "\nclass:\t{}\nmethod:\t{}\nline:\t{}\n";

    public static Response genOk() {
        return new Response()
                .setCode(ResponseCode.OK)
                .setMsg(DEFAULT_OK);
    }

    public static Response genOk(Object data) {
        return genOk()
                .setData(data);
    }

    public static Response genNo(Exception e, String defaultMsg) {
        StackTraceElement[] elements = e.getStackTrace();
        for (int i = elements.length - 1; i >= 0; i--) {
            StackTraceElement element = elements[i];
            LoggerUtils.error(ResponseGenerator.class, format, element.getClassName(), element.getMethodName(), element.getLineNumber());
        }
        return new Response()
                .setCode(ResponseCode.BAD_REQUEST)
                .setMsg(StringUtils.isEmpty(e.getMessage()) ? defaultMsg : e.getMessage());
    }

    public static Response genNo(Object data, Exception e, String defaultMsg) {
        return genNo(e, defaultMsg)
                .setData(data);
    }

}
