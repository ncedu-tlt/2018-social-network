package ru.ncedu.socialnetwork.api.models;

import ru.ncedu.socialnetwork.domain.Settings;

import java.util.List;

public class SettingsDTO {
    private List<Settings> settingUnits;
    private List<String> availableLanguages;

    public List<String> getAvailableLanguages() {
        return availableLanguages;
    }

    public void setAvailableLanguages(List<String> availableLanguages) {
        this.availableLanguages = availableLanguages;
    }

    public List<Settings> getSettingUnits() {
        return settingUnits;
    }

    public void setSettingUnits(List<Settings> settingUnits) {
        this.settingUnits = settingUnits;
    }
}
