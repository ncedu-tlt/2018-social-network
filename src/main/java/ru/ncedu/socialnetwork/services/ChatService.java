package ru.ncedu.socialnetwork.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ncedu.socialnetwork.domain.ChatDAO;
import ru.ncedu.socialnetwork.domain.UserDAO;
import ru.ncedu.socialnetwork.repositories.ChatRepository;
import ru.ncedu.socialnetwork.repositories.UserRepository;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class ChatService {
    private ChatRepository chatRepository;
    private UserRepository userRepository;

    @Autowired
    public ChatService(ChatRepository chatRepository, UserRepository userRepository) {
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void initParticipants(){
        UserDAO zorin = userRepository.findByLogin("zorin");
        UserDAO sotn = userRepository.findByLogin("sotn");

        if(zorin == null || sotn == null){
            zorin = new UserDAO();
            zorin.setUserId(1);
            zorin.setName("Andrey Zorin");
            zorin.setImagePath("https://octodex.github.com/images/electrocat.png");
            zorin.setLogin("zorin");

            sotn = new UserDAO();
            sotn.setUserId(2);
            sotn.setName("Alexandra Sotnikova");
            sotn.setImagePath("https://octodex.github.com/images/electrocat.png");
            sotn.setLogin("sotn");

            userRepository.save(zorin);
            userRepository.save(sotn);
        }
    }

    public List<ChatDAO> getChats(UserDAO user) {
         return chatRepository.findAll();
    }

    public ChatDAO getChat(int id) {
        return chatRepository.findOne(id);
    }

    public ChatDAO addChat(ChatDAO chat){
        return chatRepository.save(chat);
    }
}
