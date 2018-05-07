package ru.ncedu.socialnetwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ncedu.socialnetwork.domain.SettingsDAO;
import ru.ncedu.socialnetwork.domain.SettingsId;

import java.util.List;

@Repository
public interface SettingsRepository extends JpaRepository<SettingsDAO, SettingsId> {

    List<SettingsDAO> findBySettingsIdUserId(int userId);
} 
