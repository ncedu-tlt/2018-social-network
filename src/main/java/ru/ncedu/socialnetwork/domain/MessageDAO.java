package ru.ncedu.socialnetwork.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "messages")
public class MessageDAO {
    @Id
    private int id;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private Date dateMsg;

    @ManyToOne
    @JoinColumn(name="chat.id", nullable=false)
    private ChatDAO chat;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user.id")
    private UserDAO user;

    public MessageDAO() {
    }

    public MessageDAO(int id, String body, Date dateMsg, UserDAO user) {
        this.id = id;
        this.body = body;
        this.dateMsg = dateMsg;
        this.user = user;
    }

    public ChatDAO getChat() {
        return chat;
    }

    public void setChat(ChatDAO chat) {
        this.chat = chat;
    }

    public UserDAO getUser() {
        return user;
    }

    public void setUser(UserDAO user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDateMsg() {
        return dateMsg;
    }

    public void setDateMsg(Date dateMsg) {
        this.dateMsg = dateMsg;
    }

    public UserDAO getFromId() {
        return user;
    }

    public void setFromId(UserDAO user) {
        this.user = user;
    }
}
