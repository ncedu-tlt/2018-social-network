package ru.ncedu.socialnetwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ncedu.socialnetwork.domain.ChatDAO;

@Repository
public interface ChatRepository extends JpaRepository<ChatDAO, Integer> {

}
