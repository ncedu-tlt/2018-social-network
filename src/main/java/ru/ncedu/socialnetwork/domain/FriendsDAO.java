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
    private String avatar;
    @Column
    private String name;
    @Column
    private String login;
    @Column
    private Boolean online;

    public FriendsDAO() {
    }

    public FriendsDAO(FriendId friendId, String avatar, String name, String login, Boolean online) {
        this.friendId = friendId;
        this.avatar = avatar;
        this.name = name;
        this.login = login;
        this.online = online;
    }

    public FriendId getFriendId() {
        return friendId;
    }

    public void setFriendId(FriendId friendId) {
        this.friendId = friendId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }
}
