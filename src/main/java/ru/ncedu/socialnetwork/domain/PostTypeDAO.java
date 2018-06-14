package ru.ncedu.socialnetwork.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "post_type")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PostTypeDAO {
    @Id
    @Column(name = "post_type_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long postTypeId;

    @Column(name = "type")
    private String type;

    public PostTypeDAO() {

    }

    public long getPostTypeId() {
        return postTypeId;
    }

    public void setPostTypeId(long postTypeId) {
        this.postTypeId = postTypeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
