package ru.ncedu.socialnetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.ncedu.socialnetwork.api.models.ProjectDTO;
import ru.ncedu.socialnetwork.api.services.ProjectsGitHubService;
import ru.ncedu.socialnetwork.domain.UserDAO;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private ProjectsGitHubService projectsService;

    @Autowired
    public UserController(ProjectsGitHubService projectsService) {
        this.projectsService = projectsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public UserDAO getUser(@AuthenticationPrincipal UserDAO user){
        return user;
    }

    @RequestMapping("/{userName}/repos")
    public List<ProjectDTO> getProjects(@PathVariable("userName") String userName) {
        return projectsService.getProjects(userName);
    }
}
