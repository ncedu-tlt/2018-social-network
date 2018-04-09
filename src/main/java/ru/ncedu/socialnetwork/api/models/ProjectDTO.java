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

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public void setStargazersCount(int stargazersCount) {
        this.stargazersCount = stargazersCount;
    }

    public void setHtmlUrl(String htmlUrl) {
        this.htmlUrl = htmlUrl;
    }
}
