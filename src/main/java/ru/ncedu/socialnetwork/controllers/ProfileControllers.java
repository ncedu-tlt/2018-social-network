package ru.ncedu.socialnetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.ncedu.socialnetwork.api.models.ProfileDTO;
import ru.ncedu.socialnetwork.domain.SettingsDAO;
import ru.ncedu.socialnetwork.domain.UserDAO;
import ru.ncedu.socialnetwork.repositories.SettingsRepository;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
public class ProfileControllers {

    @Autowired
    private SettingsRepository settingsRepository;

    @Transactional
    @RequestMapping(method = RequestMethod.GET)
    public ProfileDTO getProfile(@AuthenticationPrincipal UserDAO user) {
        List<SettingsDAO> settings = settingsRepository.findBySettingsIdUserId(user.getUserId());
        ProfileDTO profileDTO = new ProfileDTO();

        profileDTO.setName(user.getName());
        profileDTO.setImagePath(user.getImagePath());
        profileDTO.setLanguages(user.getLanguages());
        profileDTO.setTechnologies(user.getTechnologies());
        profileDTO.setPlaceOfWork(user.getOrganization());
        profileDTO.setJob(user.getJob());

        SettingsDAO showLanguages = settings.stream().filter((setting) -> setting.getSettingsId().getName().equals("settings.show_language")).findFirst().get();
        SettingsDAO showTechnologies = settings.stream().filter((setting) -> setting.getSettingsId().getName().equals("settings.show_preferred_technologies")).findFirst().get();
        SettingsDAO showPlaceOfWork = settings.stream().filter((setting) -> setting.getSettingsId().getName().equals("settings.show_place_of_work")).findFirst().get();
        SettingsDAO showJob = settings.stream().filter((setting) -> setting.getSettingsId().getName().equals("settings.show_job")).findFirst().get();

        profileDTO.setShowLanguages(Boolean.valueOf(showLanguages.getValue()));
        profileDTO.setShowTechnologies(Boolean.valueOf(showTechnologies.getValue()));
        profileDTO.setShowPlaceOfWork(Boolean.valueOf(showPlaceOfWork.getValue()));
        profileDTO.setShowJob(Boolean.valueOf(showJob.getValue()));

        return profileDTO;
    }
}
