package com.bangduoduo.wxpay;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by cpeng2 on 10/14/2016.
 */
public class WxProperties {

    private final static WxProperties instance = new WxProperties();
    private Properties properties;
    private WxProperties() {
        try {
            InputStream input = WxProperties.class.getClassLoader().getResourceAsStream("wxpay/wxpay.properties");
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
     }

    public static String getProperty(String key) {
        if (instance.properties.containsKey(key)) {
            return instance.properties.get(key).toString();
        }
        return null;
    }
}
