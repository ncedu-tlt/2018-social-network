package ru.ncedu.socialnetwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ncedu.socialnetwork.domain.ChatDAO;
import ru.ncedu.socialnetwork.domain.UserDAO;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<ChatDAO, Integer> {
    List<ChatDAO> findAllByParticipants(UserDAO user);
}
