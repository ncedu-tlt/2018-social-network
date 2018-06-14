package ru.ncedu.socialnetwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ncedu.socialnetwork.domain.CommentDAO;
import ru.ncedu.socialnetwork.domain.LikeCommentDAO;
import ru.ncedu.socialnetwork.domain.UserDAO;

public interface LikeCommentRepository extends JpaRepository<LikeCommentDAO, Long> {
    LikeCommentDAO findLikeCommentDAOByCommentAndUser(CommentDAO commentDAO, UserDAO user);
}
