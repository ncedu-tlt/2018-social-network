package ru.ncedu.socialnetwork.api.models;

public class SettingUnit {
    private long userId;
    private String name;
    private String value;

    public SettingUnit() {
    }

    public SettingUnit(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
