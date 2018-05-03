package ru.ncedu.socialnetwork.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.ncedu.socialnetwork.api.models.SettingsDTO;
import ru.ncedu.socialnetwork.domain.SettingsDAO;
import ru.ncedu.socialnetwork.domain.SettingsId;
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

    @RequestMapping(method = RequestMethod.GET)
    public SettingsDTO getSettings(@AuthenticationPrincipal UserDAO user){

        SettingsDTO settingsDTO = new SettingsDTO();
        List<SettingsDAO> settingUnitList = new ArrayList<>();
        String settings[] = {"settings.show_language", "settings.show_preferred_technologies", "settings.show_place_of_work", "settings.show_job", "settings.language"} ;


        if(!settingsRepository.findAll().isEmpty()){
            settingUnitList.addAll(settingsRepository.findAll());
        } else {
            settingUnitList.add(new SettingsDAO(new SettingsId(user.getUserId(), settings[0]), settings[0], "true"));
            settingUnitList.add(new SettingsDAO(new SettingsId(user.getUserId(), settings[1]), settings[1], "true"));
            settingUnitList.add(new SettingsDAO(new SettingsId(user.getUserId(), settings[2]), settings[2], "true"));
            settingUnitList.add(new SettingsDAO(new SettingsId(user.getUserId(), settings[3]), settings[3], "true"));
            settingUnitList.add(new SettingsDAO(new SettingsId(user.getUserId(), settings[4]), settings[4], "en"));
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

       ArrayList<SettingsDAO> settings = new ArrayList<>(settingsDTO.getSettingUnits());


        if(!settingsRepository.findAll().isEmpty()){
            settingsRepository.deleteAll();
        }

        settingsRepository.save(settings);
    }
}
