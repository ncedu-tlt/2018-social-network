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

    @Embedded
    @Column(name = "from_id")
    private FromId fromId;

    public MessageDAO() {
    }

    public MessageDAO(int id, String body, Date dateMsg, FromId fromId) {
        this.id = id;
        this.body = body;
        this.dateMsg = dateMsg;
        this.fromId = fromId;
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

    public FromId getFromId() {
        return fromId;
    }

    public void setFromId(FromId fromId) {
        this.fromId = fromId;
    }
}
