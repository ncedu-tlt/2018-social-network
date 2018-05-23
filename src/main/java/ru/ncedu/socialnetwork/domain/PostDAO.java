package ru.ncedu.socialnetwork.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "posts")
public class PostDAO {
    @Id
    @Column(name = "post_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long postId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserDAO user;

    @JsonIgnore
    //@OnDelete
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CommentDAO> comments;

    @Column(name = "date", nullable = false)
    private Date date;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_type_id", nullable = false)
    private PostTypeDAO type;

    @Column(name = "content")
    private String content;

    @JsonIgnore
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "like_post")
//    private List<LikePostDAO> likes;
//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                CascadeType.PERSIST,
//                CascadeType.MERGE
//            }
//    )
//    @JoinTable(name = "post_likes",
//            joinColumns = { @JoinColumn(name = "post_id") },
//            inverseJoinColumns = { @JoinColumn(name = "like_post_id") }
//    )
    private List<LikePostDAO> likes = new ArrayList<>();

    public void addLike(LikePostDAO like) {
        this.getLikes().add(like);
    }

    public void removeLike(LikePostDAO like) {
        this.getLikes().remove(like);
    }

    public PostDAO() {

    }

    public PostDAO(UserDAO user, List<CommentDAO> comments, Date date,
                   PostTypeDAO type, String content, List<LikePostDAO> likes) {
        this.user = user;
        this.comments = comments;
        this.date = date;
        this.type = type;
        this.content = content;
        this.likes = likes;
    }

    public long getPostId() {
        return postId;
    }

    public void setPostId(long postId) {
        this.postId = postId;
    }

    public UserDAO getUser() {
        return user;
    }

    public void setUser(UserDAO user) {
        this.user = user;
    }

    public List<CommentDAO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDAO> comments) {
        this.comments = comments;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PostTypeDAO getType() {
        return type;
    }

    public void setType(PostTypeDAO type) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PostDAO)) return false;
        PostDAO postDAO = (PostDAO) o;
        return getPostId() == postDAO.getPostId() &&
                Objects.equals(getUser(), postDAO.getUser()) &&
                Objects.equals(getComments(), postDAO.getComments()) &&
                Objects.equals(getDate(), postDAO.getDate()) &&
                Objects.equals(getType(), postDAO.getType()) &&
                Objects.equals(getContent(), postDAO.getContent()) &&
                Objects.equals(getLikes(), postDAO.getLikes());
    }

    @Override
    public int hashCode() {
        return 31;
    }
}
