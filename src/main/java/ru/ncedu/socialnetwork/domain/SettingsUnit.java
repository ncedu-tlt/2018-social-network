package ru.ncedu.socialnetwork.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "settings")
public class SettingsUnit {
    @Id
    @Column
    private int userId;

    @Column
    private char interfaceLanguage;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public char getInterfaceLanguage() {
        return interfaceLanguage;
    }

    public void setInterfaceLanguage(char interfaceLanguage) {
        this.interfaceLanguage = interfaceLanguage;
    }

}
