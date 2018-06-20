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
import java.util.ArrayList;
import java.util.List;

import static ru.ncedu.socialnetwork.api.consts.SettingsConst.*;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {
    @Autowired
    private SettingsRepository settingsRepository;

    @RequestMapping(method = RequestMethod.GET)
    public SettingsDTO getSettings(@AuthenticationPrincipal UserDAO user){
        SettingsDTO settingsDTO = new SettingsDTO();
        List<SettingsDAO> settingUnitList = new ArrayList<>();


        if(!settingsRepository.findBySettingsIdUserId(user.getUserId()).isEmpty()){
            settingUnitList.addAll(settingsRepository.findBySettingsIdUserId(user.getUserId()));
        } else {
            settingUnitList.add(new SettingsDAO(new SettingsId(user.getUserId(), SHOW_LANGUAGE), "true"));
            settingUnitList.add(new SettingsDAO(new SettingsId(user.getUserId(), SHOW_PREFFERED_TECHNOLOGIES ), "true"));
            settingUnitList.add(new SettingsDAO(new SettingsId(user.getUserId(), SHOW_PLACE_OF_WORK), "true"));
            settingUnitList.add(new SettingsDAO(new SettingsId(user.getUserId(), SHOW_JOB), "true"));
            settingUnitList.add(new SettingsDAO(new SettingsId(user.getUserId(), LANGUAGE), "en"));
        }

        settingsDTO.setSettingUnits(settingUnitList);

        List<String> availableLanguages = new ArrayList<>();
        availableLanguages.add("ru");
        availableLanguages.add("en");

        settingsDTO.setAvailableLanguages(availableLanguages);

        return settingsDTO;
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<SettingsDAO> setSettings(@RequestBody SettingsDTO settingsDTO){

        ArrayList<SettingsDAO> settings = new ArrayList<>(settingsDTO.getSettingUnits());

        return settingsRepository.save(settings);
    }
}
