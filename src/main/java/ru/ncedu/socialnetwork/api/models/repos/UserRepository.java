package ru.ncedu.socialnetwork.api.models.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ncedu.socialnetwork.api.models.UserDAO;

@Repository
public interface UserRepository extends CrudRepository<UserDAO, Long> {
    UserDAO findByLogin(String login);
}
