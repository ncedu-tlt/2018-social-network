package ru.ncedu.socialnetwork.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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

    @Column(nullable = false)
    private int fromId;

    public MessageDAO() {
    }

    public MessageDAO(int id, String body, Date dateMsg, int fromId) {
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

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }
}
