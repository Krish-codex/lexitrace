package com.lexitrace.dao;

import com.lexitrace.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {

    List<Lesson> findByLanguageIdOrderByOrderIndexAsc(Long languageId);

    @Query("SELECT COUNT(l) FROM Lesson l")
    long countAllLessons();

    @Query("SELECT COUNT(l) FROM Lesson l WHERE l.languageId = :languageId")
    long countByLanguageId(Long languageId);

    boolean existsByLanguageIdAndTitle(Long languageId, String title);
}
