package ru.ncedu.socialnetwork.api.models.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.ncedu.socialnetwork.api.models.UserDTO;

@Repository
public interface UserRepository extends CrudRepository<UserDTO, Long> {
    UserDTO findByLogin(String login);
}
