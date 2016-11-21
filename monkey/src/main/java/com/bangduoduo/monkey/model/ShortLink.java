package com.bangduoduo.monkey.model;

import org.springframework.util.DigestUtils;
import java.util.Date;

public class ShortLink {
    private Long id;
    private String originalUrl;
    private String shortUrl;
    private Date createDate;

    public ShortLink() {}
    public ShortLink(String originalUrl) {
        this.originalUrl = originalUrl;
        this.shortUrl = encore(originalUrl);
        this.createDate = new Date();
    }

    private String encore(String s) {
        //不一样的url加密后是唯一的，取前8位即可，md5加密就是为了生成不一样的短号
        return  DigestUtils.md5DigestAsHex(s.getBytes()).substring(0, 8);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
