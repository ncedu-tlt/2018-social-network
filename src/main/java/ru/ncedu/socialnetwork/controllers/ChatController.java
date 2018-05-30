package ru.ncedu.socialnetwork.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.ncedu.socialnetwork.domain.ChatDAO;
import ru.ncedu.socialnetwork.domain.UserDAO;
import ru.ncedu.socialnetwork.services.ChatService;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    private ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService){
        this.chatService = chatService;
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
    public ChatDAO addChat(@RequestBody ChatDAO chat){
        return chatService.addChat(chat);
    }


}
