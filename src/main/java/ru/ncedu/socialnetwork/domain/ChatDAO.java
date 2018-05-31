package ru.ncedu.socialnetwork.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "chats")
public class ChatDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    private String avatar;

    @Column(nullable = false)
    private String name;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            mappedBy="chat")
    private Collection<MessageDAO> messages = new ArrayList<>();

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "chats"
    )
    private Collection<ParticipantId> participantsId = new ArrayList<>();

    @Column(nullable = false)
    private String type;

    public ChatDAO() {
    }

    public ChatDAO(int id, String avatar, String name, Collection<MessageDAO> messages, Collection<ParticipantId> participantsId, String type) {
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

    public Collection<ParticipantId> getParticipantsId() {
        return participantsId;
    }

    public void setParticipantsId(Collection<ParticipantId> participantsId) {
        this.participantsId = participantsId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
