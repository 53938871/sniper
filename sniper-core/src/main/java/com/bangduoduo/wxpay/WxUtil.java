package com.bangduoduo.wxpay;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by cpeng2 on 10/14/2016.
 */
public class WxUtil {
    private void createMd5Sign(WechatOrderParam wechatOrderParam) {
        SortedMap<String, String> packageParams = new TreeMap<String, String>();
        packageParams.put("appid", wechatOrderParam.getAppid());
        packageParams.put("mch_id", wechatOrderParam.getMchId());
        packageParams.put("nonce_str",wechatOrderParam.getNonceStr());
        packageParams.put("body", wechatOrderParam.getBody());
        packageParams.put("out_trade_no", wechatOrderParam.getOutTradeNo());
        packageParams.put("total_fee", wechatOrderParam.getFee());
        packageParams.put("spbill_create_ip", wechatOrderParam.getBillCreateIp());
        packageParams.put("notify_url", wechatOrderParam.getNotifyUrl());
        packageParams.put("trade_type", wechatOrderParam.getTradeType());
        packageParams.put("openid", wechatOrderParam.getOpenId());


    }

    public static void main(String[] args) {
        WxUtil w = new WxUtil();
        WechatOrderParam wo = new WechatOrderParam();
        w.createMd5Sign(wo);
    }
}
