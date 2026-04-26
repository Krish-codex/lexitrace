package com.lexitrace.dao;

import com.lexitrace.models.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findByLessonId(Long lessonId);

    @Query("SELECT COUNT(e) FROM Exercise e")
    long countAllExercises();

    @Query("SELECT COUNT(e) FROM Exercise e WHERE e.lessonId = :lessonId")
    long countByLessonId(Long lessonId);

    boolean existsByLessonIdAndQuestion(Long lessonId, String question);
}
