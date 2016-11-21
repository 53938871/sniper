package com.bangduoduo.monkey.controller;

import com.bangduoduo.monkey.model.ShortLink;
import com.bangduoduo.monkey.service.ShortLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletRequest;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
@RequestMapping("/")
public class ShortLinkController {

    @Autowired
    private ShortLinkService linkService;

    @RequestMapping(value="{shortUri}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.TEMPORARY_REDIRECT)
    public String shortUri(@PathVariable String shortUri) {
        return "redirect:"+linkService.getShortLink(shortUri).getOriginalUrl();
    }

    @RequestMapping(value="short-link/create",method = RequestMethod.POST)
    public ShortLink createShortLink(@RequestParam("originalUrl") String originalUrl) {
        return linkService.createShortLink(originalUrl);
    }

    /**
     * Return shortUri with baseUrl ( ex: http://localhost/... )
     */
    private String relocateUrl(String shortUri, ServletRequest request) {
        try {
            URL baseUrl = new URL(request.getScheme(), request.getServerName(), request.getServerPort(), "/");
            return baseUrl + shortUri;
        } catch (MalformedURLException e) {
            return shortUri;
        }
    }
}
