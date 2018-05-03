package ru.ncedu.socialnetwork.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SettingsId implements Serializable {
    @Column(name = "user_id")
    private int UserId;

    @Column(name = "name_id")
    private String name;

    public SettingsId(int userId, String name) {
        UserId = userId;
        this.name = name;
    }

    public SettingsId() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSettingName() {
        return name;
    }

    public void setSettingName(String settingName) {
        this.name = settingName;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SettingsId)) return false;
        SettingsId that = (SettingsId) o;
        return UserId == that.UserId &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(UserId, getName());
    }
}
