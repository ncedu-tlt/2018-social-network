package ru.ncedu.socialnetwork.api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import ru.ncedu.socialnetwork.enumerations.Languages;
import ru.ncedu.socialnetwork.enumerations.Technologies;

import java.util.Collection;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfileDTO {
    private String name;
    private String imagePath;
    private Collection<Languages> languages;
    private Collection<Technologies> technologies;
    private String placeOfWork;
    private String job;
    private boolean showLanguages;
    private boolean showTechnologies;
    private boolean showPlaceOfWork;
    private boolean showJob;

    public ProfileDTO() {}

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

    public boolean isShowLanguages() {
        return showLanguages;
    }

    public void setShowLanguages(boolean showLanguages) {
        this.showLanguages = showLanguages;
    }

    public boolean isShowTechnologies() {
        return showTechnologies;
    }

    public void setShowTechnologies(boolean showTechnologies) {
        this.showTechnologies = showTechnologies;
    }

    public boolean isShowPlaceOfWork() {
        return showPlaceOfWork;
    }

    public void setShowPlaceOfWork(boolean showPlaceOfWork) {
        this.showPlaceOfWork = showPlaceOfWork;
    }

    public boolean isShowJob() {
        return showJob;
    }

    public void setShowJob(boolean showJob) {
        this.showJob = showJob;
    }
}
