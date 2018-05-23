package ru.ncedu.socialnetwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ncedu.socialnetwork.domain.LikePostDAO;
import ru.ncedu.socialnetwork.domain.PostDAO;
import ru.ncedu.socialnetwork.domain.UserDAO;

public interface LikePostRepository extends JpaRepository<LikePostDAO, Long> {
    LikePostDAO findLikePostDAOByPostAndUser(PostDAO post, UserDAO user);
}
