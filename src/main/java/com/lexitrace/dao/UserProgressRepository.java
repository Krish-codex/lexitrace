package com.lexitrace.dao;

import com.lexitrace.models.UserProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserProgressRepository extends JpaRepository<UserProgress, Long> {

    List<UserProgress> findByUserId(Long userId);

    List<UserProgress> findByUserIdAndCompleted(Long userId, Boolean completed);

    Optional<UserProgress> findByUserIdAndLessonId(Long userId, Long lessonId);

    @Query("SELECT up FROM UserProgress up WHERE up.userId = :userId AND up.completed = true ORDER BY up.completedAt DESC")
    List<UserProgress> findCompletedByUserIdOrderByDate(Long userId);

    @Query("SELECT COALESCE(SUM(up.score), 0) FROM UserProgress up WHERE up.userId = :userId AND up.completed = true")
    Integer getTotalScoreByUserId(Long userId);

    @Query("SELECT COALESCE(SUM(up.timeSpentSeconds), 0) FROM UserProgress up WHERE up.userId = :userId")
    Integer getTotalTimeSpentByUserId(Long userId);

    @Query("SELECT up FROM UserProgress up WHERE up.userId = :userId AND up.completed = true AND up.completedAt >= :since")
    List<UserProgress> findCompletedSince(Long userId, LocalDateTime since);

    @Query("SELECT COUNT(up) FROM UserProgress up WHERE up.lessonId = :lessonId AND up.completed = true")
    long countCompletedByLessonId(Long lessonId);

    @Query("SELECT COUNT(up) FROM UserProgress up WHERE up.lessonId = :lessonId")
    long countAttemptsByLessonId(Long lessonId);

    @Query("SELECT up FROM UserProgress up WHERE up.userId = :userId AND up.completed = true AND up.completedAt IS NOT NULL ORDER BY up.completedAt DESC")
    List<UserProgress> findLastCompletedByUserId(Long userId);

    @Query("SELECT COUNT(DISTINCT up.lessonId) FROM UserProgress up WHERE up.userId = :userId AND up.completed = true AND up.lesson.languageId = :languageId")
    long countCompletedLessonsByUserAndLanguage(Long userId, Long languageId);
}
