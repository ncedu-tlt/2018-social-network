package ru.ncedu.socialnetwork.domain;

import javax.persistence.*;

@Entity
@Table(name = "like_post")
public class LikePostDAO {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long likePostId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDAO user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostDAO post;

//    @NaturalId
//    private boolean likeValue;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            },
//            mappedBy = "likes")
//    private List<PostDAO> posts = new ArrayList<>();

    public LikePostDAO() {

    }

    public long getLikePostId() {
        return likePostId;
    }

    public void setLikePostId(long likePostId) {
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
}
