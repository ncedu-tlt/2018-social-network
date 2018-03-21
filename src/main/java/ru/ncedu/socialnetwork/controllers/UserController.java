package ru.ncedu.socialnetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.ncedu.socialnetwork.models.Project;

import java.security.Principal;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private RestTemplate restTemplate;

    @Autowired
    public UserController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Principal getUser(Principal user){
        return user;
    }

    @RequestMapping("/authorized")
    public boolean isAuthorized(Principal user){
        return user != null;
    }

    @RequestMapping("/{userName}/repos")
    public Project[] getProjects(@PathVariable("userName") String userName){
        return restTemplate.getForObject("https://api.github.com/users/" + userName + "/repos", Project[].class);
    }
}
