package ru.ncedu.socialnetwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ncedu.socialnetwork.domain.PostDAO;
import ru.ncedu.socialnetwork.domain.UserDAO;

public interface PostRepository extends JpaRepository<PostDAO, Long> {
    PostDAO findPostDAOByPostIdAndUser(long postId, UserDAO user);
}
