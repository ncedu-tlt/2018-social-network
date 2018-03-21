package ru.ncedu.socialnetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.ncedu.socialnetwork.models.Project;

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

    @RequestMapping("/api/user/{userName}/repos")
    public Project[] getProjects(@PathVariable("userName") String userName){
        // Maybe switch from string +concat+ to apache commons lang templating via ${userName}
        return restTemplate.getForObject("https://api.github.com/users/" + userName + "/repos", Project[].class);
    }
}
