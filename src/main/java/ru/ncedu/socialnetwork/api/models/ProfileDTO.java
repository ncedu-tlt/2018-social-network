package ru.ncedu.socialnetwork.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.ncedu.socialnetwork.enumerations.Languages;
import ru.ncedu.socialnetwork.enumerations.Technologies;

import java.util.Collection;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileDTO {
    private long profileId;
    private Collection<Languages> languages;
    private Collection<Technologies> technologies;
    private String placeOfWork;
    private String job;

    public ProfileDTO() {}

    public long getProfileId() {
        return profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

    public Collection<Languages> getLanguages() {
        return languages;
    }

    public void setLanguages(Collection<Languages> languages) {
        this.languages = languages;
    }

    public Collection<Technologies> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Collection<Technologies> technologies) {
        this.technologies = technologies;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
