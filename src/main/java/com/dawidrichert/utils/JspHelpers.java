package com.dawidrichert.utils;

public class JspHelpers {

    public static String emptyIfNull(String text) {
        return text == null ? "" : text;
    }
}
