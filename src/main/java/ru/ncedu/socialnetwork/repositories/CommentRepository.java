package ru.ncedu.socialnetwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ncedu.socialnetwork.domain.CommentDAO;

public interface CommentRepository extends JpaRepository<CommentDAO, Long> {
}
