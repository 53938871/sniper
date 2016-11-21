package com.bangduoduo.util;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cpeng2 on 2/23/2015.
 */
public class Utils {
    private static Utils ourInstance = new Utils();

    public static Utils getInstance() {
        return ourInstance;
    }

    private Utils() {
    }

    public static String formatDate(String format) {
        if(StringUtils.isEmpty(format)) {
            format = "yyyy-MM-dd";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date());
    }

    public static void checkPath(String path) {
        File file = new File(path);
        if(!file.exists()) {
            file.mkdirs();
        }
    }
}
