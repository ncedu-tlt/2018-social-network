package ru.ncedu.socialnetwork.api.services;

import org.apache.commons.text.StringSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.ncedu.socialnetwork.api.consts.GitHubEndpoints;
import ru.ncedu.socialnetwork.api.models.ProjectDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GitHubProjectsService {

    private RestTemplate restTemplate;

    @Autowired
    public GitHubProjectsService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ProjectDTO> getProjects(String userName) {
        Map params = new HashMap();
        params.put("userName", userName);

        String path = StringSubstitutor.replace(GitHubEndpoints.USER_REPOS, params);
        return restTemplate.getForObject(path, List.class);
    }
}
