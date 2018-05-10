package ru.ncedu.socialnetwork.domain;

import javax.persistence.*;

@Entity
@Table(name = "settings")
public class SettingsDAO {
    @EmbeddedId
    private SettingsId settingsId;

    @Column(nullable = false)
    private String value;

    public SettingsDAO() {
    }

    public SettingsDAO(SettingsId settingsId, String value) {
        this.settingsId = settingsId;
        this.value = value;
    }

    public SettingsId getSettingsId() {
        return settingsId;
    }

    public void setSettingsId(SettingsId settingsId) {
        this.settingsId = settingsId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
