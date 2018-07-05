package ru.ncedu.socialnetwork.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import ru.ncedu.socialnetwork.enumerations.Languages;
import ru.ncedu.socialnetwork.enumerations.Technologies;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int userId;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String name;

    @Column
    private String imagePath;

    @Column
    private String organization;

    @ElementCollection(targetClass = Languages.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Enumerated(EnumType.STRING)
    @Column
    private Set<Languages> languages = new LinkedHashSet<>();

    @ElementCollection(targetClass = Technologies.class)
    @LazyCollection(LazyCollectionOption.FALSE)
    @Enumerated(EnumType.STRING)
    @Column
    private Set<Technologies> technologies = new LinkedHashSet<>();

    @Column
    private String job;

    @JsonIgnore
    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            mappedBy = "settingsId.userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<SettingsDAO> settingsDAO;

    @JsonIgnore
        @OneToMany(
            fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE,
            orphanRemoval = true,
            mappedBy = "user"
    )
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<PostDAO> postsDAO;

    @OneToOne(mappedBy = "chat", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JsonIgnore
    private MessageDAO messages;

    @ManyToMany(
            mappedBy = "participants",
            fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE
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

    public Collection<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Languages> languages) {
        this.languages = languages;
    }

    public Collection<Technologies> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<Technologies> technologies) {
        this.technologies = technologies;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public List<SettingsDAO> getSettingsDAO() {
        return settingsDAO;
    }

    public void setSettingsDAO(List<SettingsDAO> settingsDAO) {
        this.settingsDAO = settingsDAO;
    }

    public List<PostDAO> getPostsDAO() {
        return postsDAO;
    }

    public void setPostsDAO(List<PostDAO> postsDAO) {
        this.postsDAO = postsDAO;
    }
}
