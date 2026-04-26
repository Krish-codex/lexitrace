package com.lexitrace.dao;

import com.lexitrace.models.UserLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserLanguageRepository extends JpaRepository<UserLanguage, Long> {

    List<UserLanguage> findByUserId(Long userId);

    Optional<UserLanguage> findByUserIdAndLanguageId(Long userId, Long languageId);

    boolean existsByUserIdAndLanguageId(Long userId, Long languageId);

    void deleteByUserIdAndLanguageId(Long userId, Long languageId);

    long countByLanguageId(Long languageId);
}
