package ru.ncedu.socialnetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;


@RestController
public class UserController {

    private RestTemplate restTemplate;

    @Autowired
    public UserController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/api/user")
    public Principal getUser(Principal user){
        return user;
    }

    @RequestMapping("/api/user/authorized")
    public boolean isAuthorized(Principal user){
        return user != null;
    }
}
