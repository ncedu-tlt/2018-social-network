package ru.ncedu.socialnetwork.api.controllers;


import org.springframework.web.bind.annotation.RequestBody;
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
        settingUnitList.add(new SettingUnit("settings.show_language", "false"));
        settingUnitList.add(new SettingUnit("settings.show_preferred_technologies", "false"));
        settingUnitList.add(new SettingUnit("settings.show_place_of_work", "false"));
        settingUnitList.add(new SettingUnit("settings.show_job", "true"));
        settingUnitList.add(new SettingUnit("settings.language", "ru"));

        userSettings.setSettingUnits(settingUnitList);

        List<String> availableLanguages = new ArrayList<>();
        availableLanguages.add("ru");
        availableLanguages.add("en");

        userSettings.setAvailableLanguages(availableLanguages);

        return userSettings;
    }
    @RequestMapping(method = RequestMethod.POST)
    public void setSettings(Principal user, @RequestBody UserSettings userSettings){
        System.out.println(userSettings);
    }
}
