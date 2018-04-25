package ru.ncedu.socialnetwork.domain;

import javax.persistence.*;

@Entity
@Table(name = "like_post")
public class LikePostDAO {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int likePostId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDAO user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostDAO post;

    @Column
    private String likeValue;

    public LikePostDAO() {

    }

    public int getLikePostId() {
        return likePostId;
    }

    public void setLikePostId(int likePostId) {
        this.likePostId = likePostId;
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

    public String getLikeValue() {
        return likeValue;
    }

    public void setLikeValue(String likeValue) {
        this.likeValue = likeValue;
    }
}
