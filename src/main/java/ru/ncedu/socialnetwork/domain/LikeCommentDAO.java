package ru.ncedu.socialnetwork.domain;

import javax.persistence.*;

@Entity
@Table(name = "like_comment")
public class LikeCommentDAO {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int likeCommentId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDAO user;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private CommentDAO comment;

    @Column
    private String likeValue;

    public LikeCommentDAO() {

    }

    public int getLikeCommentId() {
        return likeCommentId;
    }

    public void setLikeCommentId(int likeCommentId) {
        this.likeCommentId = likeCommentId;
    }

    public UserDAO getUser() {
        return user;
    }

    public void setUser(UserDAO user) {
        this.user = user;
    }

    public CommentDAO getComment() {
        return comment;
    }

    public void setComment(CommentDAO comment) {
        this.comment = comment;
    }

    public String getLikeValue() {
        return likeValue;
    }

    public void setLikeValue(String likeValue) {
        this.likeValue = likeValue;
    }
}