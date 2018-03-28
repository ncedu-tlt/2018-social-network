package ru.ncedu.socialnetwork.api.services;

import org.apache.commons.text.StringSubstitutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.ncedu.socialnetwork.api.consts.GitHubEndpoints;
import ru.ncedu.socialnetwork.api.models.ProjectVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GitHubService {

    private RestTemplate restTemplate;
    private Map params;

    @Autowired
    public GitHubService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        params = new HashMap();
    }

    public List<ProjectVO> getProjects(String userName) {
        params.put("userName", userName);
        String path = StringSubstitutor.replace(GitHubEndpoints.USER_REPOS, params);
        return restTemplate.getForObject(path, List.class);
    }
}
