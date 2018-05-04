package ru.ncedu.socialnetwork.domain;

import javax.persistence.*;

@Entity
@Table(name = "settings")
public class SettingsDAO {

    @EmbeddedId
    private SettingsId SettingsId;

    @Column(nullable = false)
    private String value;


    public SettingsDAO(SettingsId settingsId, String value) {
        SettingsId = settingsId;
        this.value = value;
    }

    public SettingsDAO() {
    }

    public SettingsId getSettingsId() {
        return SettingsId;
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
