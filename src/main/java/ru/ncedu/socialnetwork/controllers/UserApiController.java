package ru.ncedu.socialnetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserApiController {

    @Autowired
    private OAuth2RestTemplate restTemplate;

    @RequestMapping("/api/user")
    public String getUser(){
        return restTemplate.getForObject("https://api.github.com/user", String.class);
    }
}
