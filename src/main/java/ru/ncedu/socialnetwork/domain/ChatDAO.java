package ru.ncedu.socialnetwork.domain;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Collection<MessageDAO> messages = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "Chat_User",
            joinColumns = { @JoinColumn(name = "chat_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private Collection<UserDAO> participants = new ArrayList<>();

    @Column(nullable = false)
    private String type;

    public ChatDAO() {
    }

    public ChatDAO(int id, String avatar, String name, Collection<MessageDAO> messages, Collection<UserDAO> participants, String type) {
        this.id = id;
        this.avatar = avatar;
        this.name = name;
        this.messages = messages;
        this.participants = participants;
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

    public Collection<UserDAO> getParticipants() {
        return participants;
    }

    public void setParticipants(Collection<UserDAO> participants) {
        this.participants = participants;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
