package ru.ncedu.socialnetwork.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.ncedu.socialnetwork.api.models.ProjectDTO;
import ru.ncedu.socialnetwork.api.services.GitHubProjectsService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private GitHubProjectsService projectsService;

    @Autowired
    public UserController(GitHubProjectsService projectsService) {
        this.projectsService = projectsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Principal getUser(Principal user){
        return user;
    }

    @RequestMapping("/{userName}/repos")
    public List<ProjectDTO> getProjects(@PathVariable("userName") String userName) {
        return projectsService.getProjects(userName);
    }
}
