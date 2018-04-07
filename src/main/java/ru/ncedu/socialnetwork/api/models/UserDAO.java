package ru.ncedu.socialnetwork.api.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "\"user\"")
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private int userId;

    @Column(nullable = false, unique = true)
    private String login;

    @Column
    @NotEmpty(message = "Please provide your first name")
    private String name;

    @Column
    @NotEmpty(message = "Please provide your surname")
    private String surname;

    @Column
    private String imagePath;

    @Column
    private String organization;

    public UserDAO(String login){
        this.login = login;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
