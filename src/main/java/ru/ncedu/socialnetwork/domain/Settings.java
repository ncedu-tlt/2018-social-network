package ru.ncedu.socialnetwork.domain;

import javax.persistence.*;

@Entity
@Table(name = "settings")
public class Settings {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long settingId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserDAO user;
    @Column
    private String name;
    @Column
    private String value;


    public Settings() {
    }

    public Settings(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public long getSettingId() {
        return settingId;
    }

    public void setSettingId(long settingId) {
        this.settingId = settingId;
    }

    public UserDAO getUser() {
        return user;
    }

    public void setUser(UserDAO user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
