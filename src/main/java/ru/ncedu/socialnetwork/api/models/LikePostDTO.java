package ru.ncedu.socialnetwork.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LikePostDTO {
    private long id;
    private long userId;
    private long postId;
    private boolean likeValue;

    public LikePostDTO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public boolean getLikeValue() {
        return likeValue;
    }

    public void setLikeValue(boolean likeValue) {
        this.likeValue = likeValue;
    }
}
