package ru.ncedu.socialnetwork.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
@JsonIgnoreProperties(
        value = {"date"},
        allowGetters = true
)
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

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false)
    @CreatedDate
    private Date date;

    @Column(name = "like_comment")
    private boolean likeComment;

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

    public boolean isLikeComment() {
        return likeComment;
    }

    public void setLikeComment(boolean likeComment) {
        this.likeComment = likeComment;
    }

    public PostDAO getPost() {
        return post;
    }

    public void setPost(PostDAO post) {
        this.post = post;
    }
}
