package ru.ncedu.socialnetwork.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SettingsId implements Serializable {
    @Column(name = "user_id")
    private int userId;

    @Column(name = "name")
    private String name;


    public SettingsId() {
    }

    public SettingsId(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SettingsId)) return false;
        SettingsId that = (SettingsId) o;
        return userId == that.userId &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(userId, getName());
    }
}
