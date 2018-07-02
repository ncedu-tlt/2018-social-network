package ru.ncedu.socialnetwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ncedu.socialnetwork.domain.ProfileDAO;
import ru.ncedu.socialnetwork.domain.UserDAO;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileDAO, Long> {

    ProfileDAO findByUser(UserDAO user);
}
