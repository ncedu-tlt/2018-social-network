package ru.ncedu.socialnetwork.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class ParticipantId {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(cascade =
            {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Participant_Chat",
            joinColumns = {
                    @JoinColumn(
                            name = "participant_id",
                            referencedColumnName = "id"
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "chat_id",
                            referencedColumnName = "id"
                    )
            }
    )
    private Collection<ChatDAO> chats = new ArrayList<>();

    public ParticipantId() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Collection<ChatDAO> getChats() {
        return chats;
    }

    public void setChats(Collection<ChatDAO> chats) {
        this.chats = chats;
    }
}
