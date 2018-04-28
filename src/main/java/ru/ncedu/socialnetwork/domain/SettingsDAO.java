package ru.ncedu.socialnetwork.domain;

import javax.persistence.*;

@Entity
@Table(name = "settings")
public class SettingsDAO {

    @Id
    @JoinColumn(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int settingsId;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String value;


    public SettingsDAO() {
    }

    public SettingsDAO(String name, String value) {
        this.name = name;
        this.value = value;
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

    public int getSettingsId() {
        return settingsId;
    }

    public void setSettingsId(int settingsId) {
        this.settingsId = settingsId;
    }
}
