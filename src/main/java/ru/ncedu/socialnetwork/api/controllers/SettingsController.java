package ru.ncedu.socialnetwork.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.ncedu.socialnetwork.api.models.SettingsDTO;
import ru.ncedu.socialnetwork.domain.Settings;
import ru.ncedu.socialnetwork.domain.UserDAO;
import ru.ncedu.socialnetwork.repositories.SettingsRepository;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {
    @Autowired
    private SettingsRepository settingsRepository;
    List<Settings> settingUnitList = new ArrayList<>();

    @RequestMapping(method = RequestMethod.GET)
    public SettingsDTO getSettings(Principal user){

        SettingsDTO settingsDTO = new SettingsDTO();



        if(!settingsRepository.findAll().isEmpty()){
            settingUnitList.addAll(settingsRepository.findAll());
        } else {
            settingUnitList.add(new Settings("settings.show_language", "true"));
            settingUnitList.add(new Settings("settings.show_preferred_technologies", "true"));
            settingUnitList.add(new Settings("settings.show_place_of_work", "true"));
            settingUnitList.add(new Settings("settings.show_job", "true"));
            settingUnitList.add(new Settings("settings.language", "en"));
        }

        settingsDTO.setSettingUnits(settingUnitList);

        List<String> availableLanguages = new ArrayList<>();
        availableLanguages.add("ru");
        availableLanguages.add("en");

        settingsDTO.setAvailableLanguages(availableLanguages);

        return settingsDTO;
    }
    @RequestMapping(method = RequestMethod.POST)
    public void setSettings(@AuthenticationPrincipal UserDAO user, @RequestBody SettingsDTO settingsDTO){
        System.out.println(settingsDTO);

        Settings settingsObject = new Settings();
        settingsObject.setUser(user);

        ArrayList<Settings> settings = new ArrayList<>(settingsDTO.getSettingUnits());

        if(!settingsRepository.findAll().isEmpty()){
            settingsRepository.deleteAll();
        }

        settingsRepository.save(settings);
    }
}
