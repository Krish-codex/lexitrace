package com.lexitrace.services;

import com.lexitrace.dao.ExerciseRepository;
import com.lexitrace.dao.LessonRepository;
import com.lexitrace.dao.UserProgressRepository;
import com.lexitrace.models.Exercise;
import com.lexitrace.models.Lesson;
import com.lexitrace.models.UserProgress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@SuppressWarnings("null")
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private UserProgressRepository userProgressRepository;

    // Lesson CRUD
    public List<Lesson> findByLanguageId(Long languageId) {
        return lessonRepository.findByLanguageIdOrderByOrderIndexAsc(languageId);
    }

    public Optional<Lesson> findById(Long id) {
        return lessonRepository.findById(id);
    }

    public Lesson saveLesson(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }

    public long countAllLessons() {
        return lessonRepository.countAllLessons();
    }

    // Exercise CRUD
    public List<Exercise> findExercisesByLessonId(Long lessonId) {
        return exerciseRepository.findByLessonId(lessonId);
    }

    public Optional<Exercise> findExerciseById(Long id) {
        return exerciseRepository.findById(id);
    }

    public Exercise saveExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public void deleteExercise(Long id) {
        exerciseRepository.deleteById(id);
    }

    public long countAllExercises() {
        return exerciseRepository.countAllExercises();
    }

    // Progress tracking
    public boolean isLessonUnlocked(Long userId, Long languageId, Lesson lesson) {
        if (lesson.getOrderIndex() <= 1) return true;

        List<Lesson> allLessons = lessonRepository.findByLanguageIdOrderByOrderIndexAsc(languageId);
        for (Lesson l : allLessons) {
            if (l.getOrderIndex() < lesson.getOrderIndex()) {
                Optional<UserProgress> progress = userProgressRepository.findByUserIdAndLessonId(userId, l.getId());
                if (progress.isEmpty() || !progress.get().getCompleted()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isLessonCompleted(Long userId, Long lessonId) {
        return userProgressRepository.findByUserIdAndLessonId(userId, lessonId)
                .map(UserProgress::getCompleted)
                .orElse(false);
    }

    public UserProgress completeLesson(Long userId, Long lessonId, int score, int totalPossiblePoints, int timeSpentSeconds) {
        UserProgress progress = userProgressRepository.findByUserIdAndLessonId(userId, lessonId)
                .orElseGet(() -> {
                    UserProgress p = new UserProgress();
                    p.setUserId(userId);
                    p.setLessonId(lessonId);
                    return p;
                });

        // Only mark as completed if they got at least 60% of the points
        boolean isPass = totalPossiblePoints > 0 && ((double) score / totalPossiblePoints) >= 0.6;
        
        if (isPass) {
            progress.setCompleted(true);
        }
        
        // Update score only if it's better than previous or it's the first attempt
        if (score > progress.getScore()) {
            progress.setScore(score);
        }
        
        progress.setTimeSpentSeconds(timeSpentSeconds);
        progress.setCompletedAt(LocalDateTime.now());
        return userProgressRepository.save(progress);
    }

    public Optional<UserProgress> getUserProgress(Long userId, Long lessonId) {
        return userProgressRepository.findByUserIdAndLessonId(userId, lessonId);
    }

    public List<UserProgress> getUserCompletedLessons(Long userId) {
        return userProgressRepository.findByUserIdAndCompleted(userId, true);
    }

    public Lesson getLastLesson(Long userId) {
        List<UserProgress> completed = userProgressRepository.findLastCompletedByUserId(userId);
        if (!completed.isEmpty()) {
            UserProgress last = completed.get(0);
            Lesson lastLesson = lessonRepository.findById(last.getLessonId()).orElse(null);
            if (lastLesson != null) {
                // Find next lesson
                List<Lesson> lessons = lessonRepository.findByLanguageIdOrderByOrderIndexAsc(lastLesson.getLanguageId());
                for (int i = 0; i < lessons.size(); i++) {
                    if (lessons.get(i).getId().equals(lastLesson.getId()) && i + 1 < lessons.size()) {
                        return lessons.get(i + 1);
                    }
                }
            }
            return lastLesson;
        }
        return null;
    }

    public double getLanguageProgress(Long userId, Long languageId) {
        long totalLessons = lessonRepository.countByLanguageId(languageId);
        if (totalLessons == 0) return 0.0;
        long completed = userProgressRepository.countCompletedLessonsByUserAndLanguage(userId, languageId);
        return (double) completed / totalLessons * 100;
    }
}
