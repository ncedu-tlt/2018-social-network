package ru.ncedu.socialnetwork.api.consts;

public class GitHubEndpoints {

    public static final String BASE = "https://api.github.com";
    public static final String USERS = BASE + "/users/";
    public static final String USER_REPOS = USERS + "${userName}/repos";
}
