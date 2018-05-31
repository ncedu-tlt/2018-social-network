package ru.ncedu.socialnetwork.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import ru.ncedu.socialnetwork.domain.ChatDAO;
import ru.ncedu.socialnetwork.domain.UserDAO;
import ru.ncedu.socialnetwork.repositories.ChatRepository;

import java.util.List;

@Service
public class ChatService {
    private ChatRepository chatRepository;

    @Autowired
    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public List<ChatDAO> getChats(@AuthenticationPrincipal UserDAO user) {
        return user.getChats();
    }

    public ChatDAO getChat(int id) {
        return chatRepository.findOne(id);
    }

    public ChatDAO addChat(ChatDAO chat){

        return chatRepository.save(chat);
    }
}
