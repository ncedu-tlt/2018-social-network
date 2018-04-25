package ru.ncedu.socialnetwork.domain;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class PostDAO {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDAO user;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private CommentDAO comment;

    @Column
    private String date;

    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "post_type")
    private PostTypeDAO postType;

    @ManyToOne
    @JoinColumn(name = "like_post_id")
    private LikePostDAO like;

    public PostDAO() {

    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public PostTypeDAO getPostType() {
        return postType;
    }

    public void setPostType(PostTypeDAO postType) {
        this.postType = postType;
    }

    public LikePostDAO getLike() {
        return like;
    }

    public void setLike(LikePostDAO like) {
        this.like = like;
    }
}
