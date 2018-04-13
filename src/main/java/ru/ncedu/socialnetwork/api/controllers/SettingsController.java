package ru.ncedu.socialnetwork.api.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.ncedu.socialnetwork.api.models.SettingUnit;
import ru.ncedu.socialnetwork.api.models.UserSettings;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {
    @RequestMapping(method = RequestMethod.GET)
    public UserSettings getSettings(Principal user){
        UserSettings userSettings = new UserSettings();

        List<SettingUnit> settingUnitList = new ArrayList<>();
        settingUnitList.add(new SettingUnit("Setting_show_language", "false"));
        settingUnitList.add(new SettingUnit("Setting_show_preferred_technologies", "false"));
        settingUnitList.add(new SettingUnit("Setting_show_place_of_work", "false"));
        settingUnitList.add(new SettingUnit("Setting_show_job", "true"));
        settingUnitList.add(new SettingUnit("Setting_language", "Russian"));

        userSettings.setSettingUnits(settingUnitList);

        List<String> availableLanguages = new ArrayList<>();
        availableLanguages.add("Russian");
        availableLanguages.add("English");

        userSettings.setAvailableLanguages(availableLanguages);

        return userSettings;
    }
}
