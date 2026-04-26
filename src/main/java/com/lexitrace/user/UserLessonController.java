package com.lexitrace.user;

import com.lexitrace.models.*;
import com.lexitrace.services.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserLessonController {

    @Autowired private UserService userService;
    @Autowired private LanguageService languageService;
    @Autowired private LessonService lessonService;
    @Autowired private NotificationService notificationService;
    @Autowired private AnalyticsService analyticsService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    private User getCurrentUser(Authentication auth) {
        return userService.findByEmail(auth.getName()).orElse(null);
    }

    @GetMapping("/lessons/{languageId}")
    public String lessonsPage(@PathVariable Long languageId, Authentication auth, Model model) {
        User user = getCurrentUser(auth);
        if (user == null) return "redirect:/login";

        Language language = languageService.findById(languageId).orElse(null);
        List<Lesson> lessons = lessonService.findByLanguageId(languageId);
        Map<Long, Boolean> completedMap = new HashMap<>();
        Map<Long, Boolean> unlockedMap = new HashMap<>();

        for (Lesson lesson : lessons) {
            completedMap.put(lesson.getId(), lessonService.isLessonCompleted(user.getId(), lesson.getId()));
            unlockedMap.put(lesson.getId(), lessonService.isLessonUnlocked(user.getId(), languageId, lesson));
        }

        model.addAttribute("currentPage", "languages");
        model.addAttribute("user", user);
        model.addAttribute("language", language);
        model.addAttribute("lessons", lessons);
        model.addAttribute("completedMap", completedMap);
        model.addAttribute("unlockedMap", unlockedMap);
        model.addAttribute("unreadCount", notificationService.getUnreadCount(user.getId()));
        return "user/lessons";
    }

    @GetMapping("/lesson/{lessonId}/content")
    public String lessonContentPage(@PathVariable Long lessonId, Authentication auth, Model model) {
        User user = getCurrentUser(auth);
        if (user == null) return "redirect:/login";

        Lesson lesson = lessonService.findById(lessonId).orElse(null);
        if (lesson == null) return "redirect:/user/dashboard";

        Language language = languageService.findById(lesson.getLanguageId()).orElse(null);

        model.addAttribute("currentPage", "languages");
        model.addAttribute("user", user);
        model.addAttribute("lesson", lesson);
        model.addAttribute("language", language);
        model.addAttribute("unreadCount", notificationService.getUnreadCount(user.getId()));
        return "user/lesson-content";
    }

    @GetMapping("/exercise/{lessonId}")
    public String exercisePage(@PathVariable Long lessonId, Authentication auth,
                              HttpSession session, Model model) {
        User user = getCurrentUser(auth);
        if (user == null) return "redirect:/login";

        Lesson lesson = lessonService.findById(lessonId).orElse(null);
        if (lesson == null) return "redirect:/user/dashboard";

        List<Exercise> exercises = lessonService.findExercisesByLessonId(lessonId);
        // Parse options JSON for MCQ exercises
        List<Map<String, Object>> exerciseData = new ArrayList<>();
        for (Exercise ex : exercises) {
            Map<String, Object> data = new HashMap<>();
            data.put("id", ex.getId());
            data.put("type", ex.getType());
            data.put("question", ex.getQuestion());
            data.put("correctAnswer", ex.getCorrectAnswer());
            data.put("points", ex.getPoints());
            if (ex.getOptions() != null && !ex.getOptions().isEmpty()) {
                try {
                    List<String> opts = objectMapper.readValue(ex.getOptions(), new TypeReference<List<String>>(){});
                    data.put("options", opts);
                } catch (Exception e) {
                    data.put("options", List.of());
                }
            }
            exerciseData.add(data);
        }

        session.setAttribute("lessonStartTime", System.currentTimeMillis());
        Language language = languageService.findById(lesson.getLanguageId()).orElse(null);

        model.addAttribute("currentPage", "languages");
        model.addAttribute("user", user);
        model.addAttribute("lesson", lesson);
        model.addAttribute("language", language);
        model.addAttribute("exercises", exerciseData);
        model.addAttribute("totalExercises", exercises.size());
        model.addAttribute("unreadCount", notificationService.getUnreadCount(user.getId()));
        return "user/exercise";
    }

    @PostMapping("/exercise/{lessonId}/submit")
    public String submitExercise(@PathVariable Long lessonId,
                                @RequestParam Map<String, String> answers,
                                Authentication auth, HttpSession session, Model model) {
        User user = getCurrentUser(auth);
        if (user == null) return "redirect:/login";

        List<Exercise> exercises = lessonService.findExercisesByLessonId(lessonId);
        Lesson lesson = lessonService.findById(lessonId).orElse(null);

        int totalScore = 0;
        int correctCount = 0;
        List<Map<String, Object>> results = new ArrayList<>();

        for (Exercise ex : exercises) {
            String userAnswer = answers.get("answer_" + ex.getId());
            boolean isCorrect = false;

            if (userAnswer != null) {
                isCorrect = userAnswer.trim().equalsIgnoreCase(ex.getCorrectAnswer().trim());
            }

            if (isCorrect) {
                totalScore += ex.getPoints();
                correctCount++;
            }

            Map<String, Object> result = new HashMap<>();
            result.put("question", ex.getQuestion());
            result.put("userAnswer", userAnswer != null ? userAnswer : "");
            result.put("correctAnswer", ex.getCorrectAnswer());
            result.put("isCorrect", isCorrect);
            result.put("points", ex.getPoints());
            results.add(result);
        }

        // Calculate time spent
        Long startTime = (Long) session.getAttribute("lessonStartTime");
        int timeSpent = 0;
        if (startTime != null) {
            timeSpent = (int)((System.currentTimeMillis() - startTime) / 1000);
        }

        // Save progress
        lessonService.completeLesson(user.getId(), lessonId, totalScore, timeSpent);
        userService.updateStreak(user.getId());

        // Notify
        notificationService.createNotification(user.getId(),
                "Lesson completed! You earned " + totalScore + " XP 🎉");

        Language language = lesson != null ? languageService.findById(lesson.getLanguageId()).orElse(null) : null;

        model.addAttribute("currentPage", "languages");
        model.addAttribute("user", user);
        model.addAttribute("lesson", lesson);
        model.addAttribute("language", language);
        model.addAttribute("results", results);
        model.addAttribute("totalScore", totalScore);
        model.addAttribute("correctCount", correctCount);
        model.addAttribute("totalExercises", exercises.size());
        model.addAttribute("timeSpent", timeSpent);
        model.addAttribute("unreadCount", notificationService.getUnreadCount(user.getId()));
        return "user/results";
    }
}
