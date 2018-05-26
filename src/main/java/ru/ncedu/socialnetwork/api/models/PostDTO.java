package ru.ncedu.socialnetwork.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.ncedu.socialnetwork.domain.LikePostDAO;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostDTO {
    private long id;

    private Date date;
    private String type;
    private String content;
    private Object user;

    private List<LikePostDAO> likes;
    //private List<CommentDAO> comments;

    public PostDTO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<LikePostDAO> getLikes() {
        return likes;
    }

    public void setLikes(List<LikePostDAO> likes) {
        this.likes = likes;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

//    public List<CommentDAO> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<CommentDAO> comments) {
//        this.comments = comments;
//    }
}