package ru.ncedu.socialnetwork.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "comments")
public class CommentDAO {
    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDAO user;

    @Column
    private String content;

    @Column(name = "date", nullable = false)
    private Date date;

    @JsonIgnore
    @OneToMany(mappedBy = "comment", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "like_comment")
    private List<LikeCommentDAO> likes = new ArrayList<>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private PostDAO post;

    public CommentDAO() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserDAO getUser() {
        return user;
    }

    public void setUser(UserDAO user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<LikeCommentDAO> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeCommentDAO> likes) {
        this.likes = likes;
    }

    public PostDAO getPost() {
        return post;
    }

    public void setPost(PostDAO post) {
        this.post = post;
    }
}
