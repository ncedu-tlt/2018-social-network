package ru.ncedu.socialnetwork.api.services;

import org.apache.commons.text.StringSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.ncedu.socialnetwork.api.models.ProjectGhubMod;
import ru.ncedu.socialnetwork.consts.GhubApiAddr;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private RestTemplate restTemplate;
    private GhubApiAddr ghubApiAddr;
    private StringSubstitutor sub;

    @Autowired
    public UserController(RestTemplate restTemplate) throws IllegalAccessException {
        this.restTemplate = restTemplate;
        this.ghubApiAddr = new GhubApiAddr();
        this.sub = new StringSubstitutor(ghubApiAddr.getAddreses());
    }

    @RequestMapping(method = RequestMethod.GET)
    public Principal getUser(Principal user){
        return user;
    }

    @RequestMapping("/authorized")
    public Principal isAuthorized(Principal user) {
        Optional<Principal> principal = Optional.ofNullable(user);
        return principal.orElse(new Principal() {
            @Override
            public String getName() {
                return null;
            }
        });
    }

    @RequestMapping("/{userName}/repos")
    public List<ProjectGhubMod> getProjects(@PathVariable("userName") String userName) {
        return restTemplate.getForObject(sub.replace("${USERS_URL}" + userName + "/repos"), List.class);
    }
}
