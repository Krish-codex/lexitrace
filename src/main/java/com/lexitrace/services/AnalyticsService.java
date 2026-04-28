package com.lexitrace.services;

import com.lexitrace.dao.*;
import com.lexitrace.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@SuppressWarnings("null")
public class AnalyticsService {

    @Autowired
    private UserProgressRepository userProgressRepository;

    @Autowired
    private UserStreakRepository userStreakRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private UserLanguageRepository userLanguageRepository;

    @Autowired
    private LanguageRepository languageRepository;

    /**
     * Returns XP earned per day for the last 7 days.
     */
    public Map<String, Integer> getUserWeeklyXP(Long userId) {
        Map<String, Integer> weeklyXP = new LinkedHashMap<>();
        LocalDate today = LocalDate.now();

        for (int i = 6; i >= 0; i--) {
            LocalDate date = today.minusDays(i);
            weeklyXP.put(date.toString(), 0);
        }

        LocalDateTime weekAgo = today.minusDays(6).atStartOfDay();
        List<UserProgress> recentProgress = userProgressRepository.findCompletedSince(userId, weekAgo);

        for (UserProgress up : recentProgress) {
            if (up.getCompletedAt() != null) {
                String dateKey = up.getCompletedAt().toLocalDate().toString();
                weeklyXP.merge(dateKey, up.getScore(), (a, b) -> a + b);
            }
        }

        return weeklyXP;
    }

    /**
     * Returns accuracy percentage per language for a user.
     */
    public Map<String, Double> getUserAccuracyByLanguage(Long userId) {
        Map<String, Double> accuracy = new LinkedHashMap<>();
        List<UserProgress> allProgress = userProgressRepository.findByUserId(userId);

        Map<Long, List<UserProgress>> byLesson = allProgress.stream()
                .collect(Collectors.groupingBy(UserProgress::getLessonId));

        Map<Long, List<Integer>> langScores = new HashMap<>();

        for (Map.Entry<Long, List<UserProgress>> entry : byLesson.entrySet()) {
            lessonRepository.findById(entry.getKey()).ifPresent(lesson -> {
                Long lessonId = lesson.getId();
                if (lessonId != null) {
                    long exerciseCount = exerciseRepository.countByLessonId(lessonId);
                    if (exerciseCount > 0) {
                        for (UserProgress up : entry.getValue()) {
                            int maxPoints = (int) (exerciseCount * 10); // approximate
                            int pct = maxPoints > 0 ? (int) ((double) up.getScore() / maxPoints * 100) : 0;
                            Long langId = lesson.getLanguageId();
                            if (langId != null) {
                                langScores.computeIfAbsent(langId, k -> new ArrayList<>()).add(pct);
                            }
                        }
                    }
                }
            });
        }

        for (Map.Entry<Long, List<Integer>> entry : langScores.entrySet()) {
            Long langId = entry.getKey();
            if (langId != null) {
                languageRepository.findById(langId).ifPresent(lang -> {
                    double avg = entry.getValue().stream().mapToInt(Integer::intValue).average().orElse(0);
                    accuracy.put(lang.getName(), Math.min(avg, 100.0));
                });
            }
        }

        return accuracy;
    }

    /**
     * Returns the completion rate for a specific lesson.
     */
    public Double getLessonCompletionRate(Long lessonId) {
        long attempts = userProgressRepository.countAttemptsByLessonId(lessonId);
        if (attempts == 0) return 0.0;
        long completed = userProgressRepository.countCompletedByLessonId(lessonId);
        return (double) completed / attempts * 100;
    }

    /**
     * Returns top users by total XP.
     */
    public List<UserRankDTO> getPlatformTopUsers(int limit) {
        List<UserRankDTO> topUsers = new ArrayList<>();
        List<User> allUsers = userRepository.findAll();

        for (User user : allUsers) {
            if ("ADMIN".equals(user.getRole())) continue;
            Integer totalPoints = userProgressRepository.getTotalScoreByUserId(user.getId());
            topUsers.add(new UserRankDTO(user.getId(), user.getName(), user.getProfilePic(), totalPoints != null ? totalPoints : 0, 0));
        }

        topUsers.sort((a, b) -> Integer.compare(b.getTotalPoints(), a.getTotalPoints()));

        for (int i = 0; i < topUsers.size(); i++) {
            topUsers.get(i).setRank(i + 1);
        }

        return topUsers.stream().limit(limit).collect(Collectors.toList());
    }

    /**
     * Returns current streak for a user.
     */
    public int getUserStreak(Long userId) {
        return userStreakRepository.findByUserId(userId)
                .map(UserStreak::getCurrentStreak)
                .orElse(0);
    }

    /**
     * Returns language popularity as enrollment counts.
     */
    public Map<String, Integer> getLanguagePopularity() {
        Map<String, Integer> popularity = new LinkedHashMap<>();
        List<Language> languages = languageRepository.findAll();

        for (Language lang : languages) {
            Long langId = lang.getId();
            if (langId != null) {
                long count = userLanguageRepository.countByLanguageId(langId);
                popularity.put(lang.getName(), (int) count);
            }
        }

        return popularity;
    }

    /**
     * Returns total XP for a user.
     */
    public int getTotalXP(Long userId) {
        Integer total = userProgressRepository.getTotalScoreByUserId(userId);
        return total != null ? total : 0;
    }

    /**
     * Returns total time spent learning in seconds.
     */
    public int getTotalTimeSpent(Long userId) {
        return userProgressRepository.getTotalTimeSpentByUserId(userId);
    }

    /**
     * Returns lessons completed per language for a user.
     */
    public Map<String, Integer> getLessonsCompletedPerLanguage(Long userId) {
        Map<String, Integer> result = new LinkedHashMap<>();
        List<UserProgress> completed = userProgressRepository.findByUserIdAndCompleted(userId, true);

        Map<Long, Integer> langCounts = new HashMap<>();
        for (UserProgress up : completed) {
            Long lessonId = up.getLessonId();
            if (lessonId != null) {
                lessonRepository.findById(lessonId).ifPresent(lesson -> {
                    Long langId = lesson.getLanguageId();
                    if (langId != null) {
                        langCounts.merge(langId, 1, (a, b) -> a + b);
                    }
                });
            }
        }

        for (Map.Entry<Long, Integer> entry : langCounts.entrySet()) {
            Long langId = entry.getKey();
            if (langId != null) {
                languageRepository.findById(langId).ifPresent(lang -> {
                    result.put(lang.getName(), entry.getValue());
                });
            }
        }

        return result;
    }

    /**
     * Returns activity dates for streak calendar (last 90 days).
     */
    public Map<String, Integer> getActivityCalendar(Long userId) {
        Map<String, Integer> calendar = new LinkedHashMap<>();
        LocalDate today = LocalDate.now();

        for (int i = 89; i >= 0; i--) {
            calendar.put(today.minusDays(i).toString(), 0);
        }

        LocalDateTime since = today.minusDays(89).atStartOfDay();
        List<UserProgress> recent = userProgressRepository.findCompletedSince(userId, since);

        for (UserProgress up : recent) {
            if (up.getCompletedAt() != null) {
                String dateKey = up.getCompletedAt().toLocalDate().toString();
                calendar.merge(dateKey, up.getScore(), (a, b) -> a + b);
            }
        }

        return calendar;
    }

    /**
     * Returns badges/achievements for a user.
     */
    public List<Map<String, String>> getUserBadges(Long userId) {
        List<Map<String, String>> badges = new ArrayList<>();
        int totalXP = getTotalXP(userId);
        int streak = getUserStreak(userId);
        long completedLessons = userProgressRepository.findByUserIdAndCompleted(userId, true).size();

        if (completedLessons >= 1) {
            badges.add(Map.of("name", "First Lesson", "icon", "🎓", "description", "Completed your first lesson"));
        }
        if (totalXP >= 100) {
            badges.add(Map.of("name", "100 XP", "icon", "⭐", "description", "Earned 100 XP total"));
        }
        if (totalXP >= 500) {
            badges.add(Map.of("name", "500 XP", "icon", "🌟", "description", "Earned 500 XP total"));
        }
        if (totalXP >= 1000) {
            badges.add(Map.of("name", "1000 XP", "icon", "💫", "description", "Earned 1000 XP total"));
        }
        if (streak >= 3) {
            badges.add(Map.of("name", "3-Day Streak", "icon", "🔥", "description", "3 days in a row!"));
        }
        if (streak >= 7) {
            badges.add(Map.of("name", "7-Day Streak", "icon", "🔥🔥", "description", "A whole week streak!"));
        }
        if (streak >= 30) {
            badges.add(Map.of("name", "30-Day Streak", "icon", "🏆", "description", "One month of dedication!"));
        }
        if (completedLessons >= 5) {
            badges.add(Map.of("name", "5 Lessons", "icon", "📚", "description", "Completed 5 lessons"));
        }
        if (completedLessons >= 15) {
            badges.add(Map.of("name", "15 Lessons", "icon", "🎯", "description", "Completed 15 lessons"));
        }

        return badges;
    }

    /**
     * Platform-wide XP distribution for admin analytics.
     */
    public Map<String, Integer> getPlatformXPDistribution() {
        Map<String, Integer> distribution = new LinkedHashMap<>();
        distribution.put("0-50", 0);
        distribution.put("51-100", 0);
        distribution.put("101-250", 0);
        distribution.put("251-500", 0);
        distribution.put("500+", 0);

        List<User> users = userRepository.findAll();
        for (User user : users) {
            if ("ADMIN".equals(user.getRole())) continue;
            int xp = userProgressRepository.getTotalScoreByUserId(user.getId());
            if (xp <= 50) distribution.merge("0-50", 1, (a, b) -> a + b);
            else if (xp <= 100) distribution.merge("51-100", 1, (a, b) -> a + b);
            else if (xp <= 250) distribution.merge("101-250", 1, (a, b) -> a + b);
            else if (xp <= 500) distribution.merge("251-500", 1, (a, b) -> a + b);
            else distribution.merge("500+", 1, (a, b) -> a + b);
        }

        return distribution;
    }

    /**
     * Completion rates per lesson for admin analytics.
     */
    public Map<String, Double> getCompletionRatesPerLesson() {
        Map<String, Double> rates = new LinkedHashMap<>();
        List<Lesson> allLessons = lessonRepository.findAll();

        for (Lesson lesson : allLessons) {
            Long lessonId = lesson.getId();
            if (lessonId != null) {
                double rate = getLessonCompletionRate(lessonId);
                Long langId = lesson.getLanguageId();
                if (langId != null) {
                    languageRepository.findById(langId).ifPresent(lang -> {
                        rates.put(lang.getName() + " - " + lesson.getTitle(), rate);
                    });
                }
            }
        }

        return rates;
    }

    /**
     * Drop-off analysis: lessons where users have started but not completed.
     */
    public Map<String, Long> getDropOffAnalysis() {
        Map<String, Long> dropOff = new LinkedHashMap<>();
        List<Lesson> allLessons = lessonRepository.findAll();

        for (Lesson lesson : allLessons) {
            Long lessonId = lesson.getId();
            if (lessonId != null) {
                long attempts = userProgressRepository.countAttemptsByLessonId(lessonId);
                long completed = userProgressRepository.countCompletedByLessonId(lessonId);
                long dropped = attempts - completed;
                if (dropped > 0) {
                    Long langId = lesson.getLanguageId();
                    if (langId != null) {
                        languageRepository.findById(langId).ifPresent(lang -> {
                            dropOff.put(lang.getName() + " - " + lesson.getTitle(), dropped);
                        });
                    }
                }
            }
        }

        return dropOff;
    }

    /**
     * New registrations per day for the last 30 days.
     */
    public Map<String, Long> getNewRegistrations() {
        Map<String, Long> registrations = new LinkedHashMap<>();
        LocalDate today = LocalDate.now();

        for (int i = 29; i >= 0; i--) {
            registrations.put(today.minusDays(i).toString(), 0L);
        }

        List<User> allUsers = userRepository.findAll();
        for (User user : allUsers) {
            if (user.getCreatedAt() != null) {
                String dateKey = user.getCreatedAt().toLocalDate().toString();
                registrations.computeIfPresent(dateKey, (k, v) -> v + 1);
            }
        }

        return registrations;
    }
}
