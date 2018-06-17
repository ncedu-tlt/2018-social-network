package ru.ncedu.socialnetwork.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ncedu.socialnetwork.domain.UserDAO;
import ru.ncedu.socialnetwork.repositories.UserRepository;

import javax.annotation.PostConstruct;

@Service
public class FakeParticipantsService {
    private UserRepository userRepository;

    @Autowired
    FakeParticipantsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initParticipants(){
        UserDAO zorin = userRepository.findByLogin("zorin");
        UserDAO sotn = userRepository.findByLogin("sotn");

        if(zorin == null || sotn == null){
            zorin = new UserDAO();
            zorin.setName("Andrey Zorin");
            zorin.setImagePath("https://octodex.github.com/images/electrocat.png");
            zorin.setLogin("zorin");

            sotn = new UserDAO();
            sotn.setName("Alexandra Sotnikova");
            sotn.setImagePath("https://octodex.github.com/images/electrocat.png");
            sotn.setLogin("sotn");

            userRepository.save(zorin);
            userRepository.save(sotn);
        }
    }
}
