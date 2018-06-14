package ru.ncedu.socialnetwork.domain;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "friends")
public class FriendsDAO {
    @EmbeddedId
    private FriendId friendId;
    @Column
    private boolean accept;

    public FriendsDAO() {
    }

    public FriendsDAO(FriendId friendId, boolean accept) {
        this.friendId = friendId;
        this.accept = accept;
    }

    public FriendId getFriendId() {
        return friendId;
    }

    public void setFriendId(FriendId friendId) {
        this.friendId = friendId;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }
}
