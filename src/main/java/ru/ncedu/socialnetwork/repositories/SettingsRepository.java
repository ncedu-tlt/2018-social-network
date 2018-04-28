package ru.ncedu.socialnetwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ncedu.socialnetwork.domain.SettingsDAO;

@Repository
public interface SettingsRepository extends JpaRepository<SettingsDAO, Long> {
} 
