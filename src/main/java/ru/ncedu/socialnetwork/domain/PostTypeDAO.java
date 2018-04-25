package ru.ncedu.socialnetwork.domain;

import javax.persistence.*;

@Entity
@Table(name = "post_type")
public class PostTypeDAO {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postTypeId;

    @Column
    private String type;

    public PostTypeDAO() {

    }

    public int getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(int postTypeId) {
        this.postTypeId = postTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
