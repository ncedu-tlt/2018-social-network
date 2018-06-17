package ru.ncedu.socialnetwork.models;

import ru.ncedu.socialnetwork.domain.MessageDAO;

import java.util.ArrayList;
import java.util.Collection;

public class ChatDTO {
    private int id;
    private String avatar;
    private String name;
    private Collection<MessageDAO> messages = new ArrayList<>();
    private Collection<Integer> participantsId = new ArrayList<>();
    private String type;

    public ChatDTO() {
    }

    public ChatDTO(int id, String avatar, String name, Collection<MessageDAO> messages, Collection<Integer> participantsId, String type) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.messages = messages;
        this.participantsId = participantsId;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<MessageDAO> getMessages() {
        return messages;
    }

    public void setMessages(Collection<MessageDAO> messages) {
        this.messages = messages;
    }

    public Collection<Integer> getParticipantsId() {
        return participantsId;
    }

    public void setParticipantsId(Collection<Integer> participantsId) {
        this.participantsId = participantsId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
