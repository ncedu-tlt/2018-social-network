package ru.ncedu.socialnetwork.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDTO {
    private long id;
    private String name;
    private String description;
    private String language;
    private boolean fork;

    @JsonProperty("stargazers_count")
    private int stargazersCount;

    @JsonProperty("html_url")
    private String htmlUrl;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isFork() { return fork; }

    public int getStargazersCount() {
        return stargazersCount;
    }

    public String getHtmlUrl() { return htmlUrl; }
}
