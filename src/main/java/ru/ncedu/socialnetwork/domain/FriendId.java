package ru.ncedu.socialnetwork.domain;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FriendId implements Serializable {
    @Column
    private int userId;
    @Column
    private int Id;

    public FriendId() {
    }

    public FriendId(int userId, int id) {
        this.userId = userId;
        Id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FriendId)) return false;
        FriendId friendId = (FriendId) o;
        return getUserId() == friendId.getUserId() &&
                getId() == friendId.getId();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getUserId(), getId());
    }
}
