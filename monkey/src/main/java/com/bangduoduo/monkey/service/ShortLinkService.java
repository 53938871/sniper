package com.bangduoduo.monkey.service;


import com.bangduoduo.monkey.ApplicationContextProvider;
import com.bangduoduo.monkey.model.ShortLink;
import com.bangduoduo.monkey.repository.ShortLinkMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortLinkService {

    @Autowired
    private ShortLinkMapper shortLinkMapper;

    public ShortLink getShortLink(String shortUrl) {
        return shortLinkMapper.findByShortUri(shortUrl);
    }

    public ShortLink createShortLink(String originalUrl) {
        ShortLink shortLink = new ShortLink(originalUrl);
        long id = shortLinkMapper.createShortLink(shortLink);
        return shortLinkMapper.findById(id);
    }


}
