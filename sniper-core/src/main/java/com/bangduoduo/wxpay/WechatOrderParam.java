package com.bangduoduo.wxpay;

public final class WechatOrderParam {

    private String tradeType = "JSAPI";
    //内容描述
    private String body;
    //订单号
    private String outTradeNo;
    //下单的ip
    private String billCreateIp;
    private String appid;
    private String appSecret;
    private String mchId;
    private String parentKey;
    private String nonceStr;
    private String fee;
    private String notifyUrl;
    private String openId;
    private String timeStamp;
    private String sign;

    public WechatOrderParam() {}
    public WechatOrderParam(String appid,String appSecret, String mchId,String parentKey) {
        this.appid = appid;
        this.appSecret = appSecret;
        this.mchId = mchId;
        this.parentKey = parentKey;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getBillCreateIp() {
        return billCreateIp;
    }

    public void setBillCreateIp(String billCreateIp) {
        this.billCreateIp = billCreateIp;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMchId() {
        return mchId;
    }

    public void setMchId(String mchId) {
        this.mchId = mchId;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getParentKey() {
        return parentKey;
    }

    public void setParentKey(String parentKey) {
        this.parentKey = parentKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
