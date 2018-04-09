package ru.ncedu.socialnetwork.domains.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ncedu.socialnetwork.domains.UserDAO;

@Repository
public interface UserRepository extends CrudRepository<UserDAO, Long> {
    UserDAO findByLogin(String login);
}
