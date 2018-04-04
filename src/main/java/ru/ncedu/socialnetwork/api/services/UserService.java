package ru.ncedu.socialnetwork.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ncedu.socialnetwork.api.models.UserDTO;
import ru.ncedu.socialnetwork.api.models.repos.UserRepository;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO findByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    public void saveUser(UserDTO user) {
        userRepository.save(user);
    }

}