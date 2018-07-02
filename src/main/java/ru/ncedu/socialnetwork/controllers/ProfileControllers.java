package ru.ncedu.socialnetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.ncedu.socialnetwork.api.models.ProfileDTO;
import ru.ncedu.socialnetwork.domain.ProfileDAO;
import ru.ncedu.socialnetwork.domain.UserDAO;
import ru.ncedu.socialnetwork.repositories.ProfileRepository;

@RestController
@RequestMapping("/api/profile")
public class ProfileControllers {

    @Autowired
    private ProfileRepository profileRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ProfileDTO getProfile(@AuthenticationPrincipal UserDAO user) {
        ProfileDAO profileDAO = profileRepository.findByUser(user);
        ProfileDTO profileDTO = new ProfileDTO();

        if (profileDAO == null) {
            setProfile(profileDTO, user);
        } else {
            profileDTO.setProfileId(profileDAO.getProfileId());
            profileDTO.setLanguages(profileDAO.getLanguages());
            profileDTO.setTechnologies(profileDAO.getTechnologies());
            profileDTO.setPlaceOfWork(profileDAO.getPlaceOfWork());
            profileDTO.setJob(profileDAO.getJob());
        }

        return profileDTO;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProfileDAO setProfile(@RequestBody ProfileDTO profileDTO, UserDAO userDAO) {
        ProfileDAO profileDAO = new ProfileDAO();
        profileDAO.setLanguages(profileDTO.getLanguages());
        profileDAO.setTechnologies(profileDTO.getTechnologies());
        profileDAO.setPlaceOfWork(profileDTO.getPlaceOfWork());
        profileDAO.setJob(profileDTO.getJob());
        profileDAO.setUser(userDAO);

        return profileRepository.save(profileDAO);
    }
}
