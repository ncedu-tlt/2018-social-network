package ru.ncedu.socialnetwork.api.models;

import ru.ncedu.socialnetwork.domain.SettingsDAO;

import java.util.List;

public class SettingsDTO {
    private List<SettingsDAO> settingUnits;
    private List<String> availableLanguages;

    public List<String> getAvailableLanguages() {
        return availableLanguages;
    }

    public void setAvailableLanguages(List<String> availableLanguages) {
        this.availableLanguages = availableLanguages;
    }

    public List<SettingsDAO> getSettingUnits() {
        return settingUnits;
    }

    public void setSettingUnits(List<SettingsDAO> settingUnits) {
        this.settingUnits = settingUnits;
    }
}
