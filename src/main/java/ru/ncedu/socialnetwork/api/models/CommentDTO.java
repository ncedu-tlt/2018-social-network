package ru.ncedu.socialnetwork.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.ncedu.socialnetwork.domain.LikeCommentDAO;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentDTO {
    private long id;
    private long postId;

    private Date date;
    private Object user;
    private String content;
    private List<LikeCommentDAO> likes;

    public CommentDTO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<LikeCommentDAO> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeCommentDAO> likes) {
        this.likes = likes;
    }
}
