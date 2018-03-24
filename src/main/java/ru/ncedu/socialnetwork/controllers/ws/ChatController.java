package ru.ncedu.socialnetwork.controllers.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ru.ncedu.socialnetwork.models.Message;

import java.security.Principal;

@Controller
@MessageMapping("/chat")
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/message")
    @SendTo("/topic/chat/message")
    public Message sendMessage(@Payload Message message, Principal principal) {
        return new Message(principal.getName(), message.getText());
    }
}
