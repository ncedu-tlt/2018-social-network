package ru.ncedu.socialnetwork.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.ncedu.socialnetwork.api.models.ProjectVO;
import ru.ncedu.socialnetwork.api.services.GitHubService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private GitHubService ghService;

    @Autowired
    public UserController(GitHubService ghService) {
        this.ghService = ghService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Principal getUser(Principal user){
        return user;
    }

    @RequestMapping("/{userName}/repos")
    public List<ProjectVO> getProjects(@PathVariable("userName") String userName) {
        return ghService.getProjects(userName);
    }
}
