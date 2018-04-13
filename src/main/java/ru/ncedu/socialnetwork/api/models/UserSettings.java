package ru.ncedu.socialnetwork.api.models;

import java.util.ArrayList;
import java.util.List;

public class UserSettings {
    private List<SettingUnit> settingUnits;
    private List<String> availableLanguages;

    public List<String> getAvailableLanguages() {
        return availableLanguages;
    }

    public void setAvailableLanguages(List<String> availableLanguages) {
        this.availableLanguages = availableLanguages;
    }

    public List<SettingUnit> getSettingUnits() {
        return settingUnits;
    }

    public void setSettingUnits(List<SettingUnit> settingUnits) {
        this.settingUnits = settingUnits;
    }
}
