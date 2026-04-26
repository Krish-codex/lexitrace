package com.lexitrace.dao;

import com.lexitrace.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

    List<Language> findByIsActiveTrue();

    Optional<Language> findByCode(String code);

    boolean existsByCode(String code);
}
