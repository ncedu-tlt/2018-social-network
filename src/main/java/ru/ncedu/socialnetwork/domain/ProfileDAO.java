package ru.ncedu.socialnetwork.domain;

import ru.ncedu.socialnetwork.enumerations.Languages;
import ru.ncedu.socialnetwork.enumerations.Technologies;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "profiles")
public class ProfileDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_id")
    private long profileId;

    @ElementCollection(targetClass = Languages.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "languages")
    private Collection<Languages> languages;

    @ElementCollection(targetClass = Technologies.class)
    @Enumerated(EnumType.STRING)
    @Column(name = "technologies")
    private Collection<Technologies> technologies;

    @Column(name = "place_of_work")
    private String placeOfWork;

    @Column(name = "job")
    private String job;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    UserDAO user;

    public ProfileDAO() {}

    public long getProfileId() {
        return profileId;
    }

    public void setProfileId(long profileId) {
        this.profileId = profileId;
    }

    public UserDAO getUser() {
        return user;
    }

    public void setUser(UserDAO user) {
        this.user = user;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (int) (prime * result * profileId);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if(obj instanceof ProfileDAO) {
            ProfileDAO profileObject = (ProfileDAO) obj;
            return profileObject.getProfileId() == profileId;
        }
        return false;
    }
}
