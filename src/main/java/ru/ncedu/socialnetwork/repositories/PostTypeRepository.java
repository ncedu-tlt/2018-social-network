package ru.ncedu.socialnetwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ncedu.socialnetwork.domain.PostTypeDAO;

public interface PostTypeRepository extends JpaRepository<PostTypeDAO, Long> {
}
