package ru.ncedu.socialnetwork.domain;

import javax.persistence.*;

@Entity
@Table(name = "post_wall")
public class PostWallDAO {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postWallId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDAO user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostDAO post;

    public PostWallDAO() {

    }

    public int getPostWallId() {
        return postWallId;
    }

    public void setPostWallId(int postWallId) {
        this.postWallId = postWallId;
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
}
