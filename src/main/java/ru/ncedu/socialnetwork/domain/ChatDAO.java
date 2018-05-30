package ru.ncedu.socialnetwork.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "chats")
public class ChatDAO {
    @Id
    private int id;

    @Column
    private String avatar;

    @Column(nullable = false, unique = true)
    private String name;

    @ElementCollection
    private Collection<MessageDAO> messages;

    @Column(nullable = false)
    private Date dateMsg;

    @ElementCollection
    private Collection<Integer> participantsId;

    @Column(nullable = false)
    private String type;

    public ChatDAO() {
    }

    public ChatDAO(int id, String avatar, String name, Collection<MessageDAO> messages, Date dateMsg, Collection<Integer> participantsId, String type) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.messages = messages;
        this.dateMsg = dateMsg;
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

    public Date getDateMsg() {
        return dateMsg;
    }

    public void setDateMsg(Date dateMsg) {
        this.dateMsg = dateMsg;
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
