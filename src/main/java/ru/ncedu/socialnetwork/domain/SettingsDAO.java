package ru.ncedu.socialnetwork.domain;

import javax.persistence.*;

@Entity
@Table(name = "settings")
public class SettingsDAO {

    @EmbeddedId
    private SettingsId SettingsId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String value;


    public SettingsDAO() {
    }

    public SettingsDAO(SettingsId settingsId, String name, String value) {
        SettingsId = settingsId;
        this.name = name;
        this.value = value;
    }

    public SettingsDAO(String name, String value) {
        this.value = value;
    }

    public SettingsId getSettingsId() {
        return SettingsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSettingsId(SettingsId settingsId) {
        this.SettingsId = settingsId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
