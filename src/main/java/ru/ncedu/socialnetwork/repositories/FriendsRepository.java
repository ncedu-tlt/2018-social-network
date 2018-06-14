package ru.ncedu.socialnetwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ncedu.socialnetwork.domain.FriendId;
import ru.ncedu.socialnetwork.domain.FriendsDAO;

import java.util.List;

public interface FriendsRepository extends JpaRepository<FriendsDAO, FriendId> {
    List<FriendsDAO> findAllByFriendIdUserId(int userId);
}
