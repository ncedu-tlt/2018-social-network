package ru.ncedu.socialnetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.ncedu.socialnetwork.domain.ChatDAO;
import ru.ncedu.socialnetwork.domain.UserDAO;
import ru.ncedu.socialnetwork.models.ChatDTO;
import ru.ncedu.socialnetwork.repositories.UserRepository;
import ru.ncedu.socialnetwork.services.ChatService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private ChatService chatService;
    private UserRepository userRepository;

    @Autowired
    public ChatController(ChatService chatService, UserRepository userRepository){
        this.chatService = chatService;
        this.userRepository = userRepository;
    }

    @RequestMapping("/{id}")
    public ChatDAO getChat(@PathVariable("id") int id){
        return chatService.getChat(id);
    }

    @RequestMapping
    public List<ChatDAO> getChats(@AuthenticationPrincipal UserDAO user){
        return chatService.getChats(user);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ChatDAO addChat(@AuthenticationPrincipal UserDAO user, @RequestBody ChatDTO chat){
        ChatDAO chatDAO = new ChatDAO();
        Collection<UserDAO> participantsCollection = new ArrayList<>();

        if(chat.getParticipantsId().size()==2){
            chatDAO.setType("Dialog");
            Optional<Integer> chatWithParticipantId = chat.getParticipantsId().stream().findFirst();
            UserDAO participant = userRepository.findOne(chatWithParticipantId.get());
            chatDAO.setAvatar(participant.getImagePath());
            chatDAO.setName(participant.getName());
            chatDAO.setMessages(chat.getMessages());

            participantsCollection.add(participant);
            participantsCollection.add(user);
            chatDAO.setParticipants(participantsCollection);
        }
        else {
            StringBuilder nameBuilder = new StringBuilder();

            chatDAO.setType("Conference");
            chatDAO.setAvatar("https://octodex.github.com/images/electrocat.png");
            chatDAO.setMessages(chat.getMessages());
            for(int participantId : chat.getParticipantsId()){
                UserDAO participant = userRepository.findOne(participantId);
                participantsCollection.add(participant);
                nameBuilder.append(participant.getName());
                nameBuilder.append(" ");
            }
            chatDAO.setName(nameBuilder.toString());
            chatDAO.setParticipants(participantsCollection);
        }

        return chatService.addChat(chatDAO);
    }


}
