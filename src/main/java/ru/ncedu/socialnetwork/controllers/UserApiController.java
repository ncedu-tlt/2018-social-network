package ru.ncedu.socialnetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;


@RestController
public class UserApiController {

    private RestTemplate restTemplate;

    @Autowired
    public UserApiController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/api/user")
    public String getUser(){
        return restTemplate.getForObject("https://api.github.com/user", String.class);
    }

    @RequestMapping("/api/user/authorized")
    public boolean isAuthorized(Principal user){
        return user != null;
    }
}
