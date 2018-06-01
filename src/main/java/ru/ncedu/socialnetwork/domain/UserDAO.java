package ru.ncedu.socialnetwork.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String name;

    @Column
    private String imagePath;

    @Column
    private String organization;

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            mappedBy = "settingsId.userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<SettingsDAO> settingsDAO;

    @OneToOne(mappedBy = "chat", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JsonIgnore
    private MessageDAO messages;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "User_Chat",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "chat_id") }
    )
    @JsonIgnore
    private List<ChatDAO> chats = new ArrayList<>();

    public List<ChatDAO> getChats() {
        return chats;
    }

    public MessageDAO getMessages() {
        return messages;
    }

    public void setMessages(MessageDAO messages) {
        this.messages = messages;
    }

    public void setChats(List<ChatDAO> chats) {
        this.chats = chats;
    }

    public UserDAO() {}

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}
