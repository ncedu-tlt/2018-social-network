package ru.ncedu.socialnetwork.domain;

import javax.persistence.*;

@Entity
@Table(name = "comments")
public class CommentDAO {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int commentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDAO user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostDAO post;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "like_comment_id")
    private LikeCommentDAO like;

    public CommentDAO() {

    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public UserDAO getUser() {
        return user;
    }

    public void setUser(UserDAO user) {
        this.user = user;
    }

    public PostDAO getPost() {
        return post;
    }

    public void setPost(PostDAO post) {
        this.post = post;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LikeCommentDAO getLike() {
        return like;
    }

    public void setLike(LikeCommentDAO like) {
        this.like = like;
    }
}
