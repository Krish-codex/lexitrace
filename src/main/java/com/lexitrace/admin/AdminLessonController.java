package com.lexitrace.admin;

import com.lexitrace.models.*;
import com.lexitrace.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminLessonController {

    @Autowired private UserService userService;
    @Autowired private LanguageService languageService;
    @Autowired private LessonService lessonService;
    @Autowired private AuditLogService auditLogService;

    @GetMapping("/lessons")
    public String lessonsPage(@RequestParam(required = false) Long languageId,
                             Authentication auth, Model model) {
        User admin = userService.findByEmail(auth.getName()).orElse(null);
        model.addAttribute("currentPage", "lessons");
        model.addAttribute("user", admin);
        model.addAttribute("languages", languageService.findAllLanguages());
        if (languageId != null) {
            model.addAttribute("selectedLanguageId", languageId);
            model.addAttribute("lessons", lessonService.findByLanguageId(languageId));
            model.addAttribute("selectedLanguage", languageService.findById(languageId).orElse(null));
        }
        return "admin/lessons";
    }

    @PostMapping("/lessons/add")
    public String addLesson(@RequestParam Long languageId, @RequestParam String title,
                           @RequestParam String description, @RequestParam String content,
                           @RequestParam String difficulty, @RequestParam Integer orderIndex, Authentication auth) {
        User admin = userService.findByEmail(auth.getName()).orElse(null);
        Lesson lesson = new Lesson();
        lesson.setLanguageId(languageId);
        lesson.setTitle(title);
        lesson.setDescription(description);
        lesson.setContent(content);
        lesson.setDifficulty(difficulty);
        lesson.setOrderIndex(orderIndex);
        lessonService.saveLesson(lesson);
        auditLogService.log(admin.getId(), "Added lesson: " + title, null);
        return "redirect:/admin/lessons?languageId=" + languageId;
    }

    @PostMapping("/lessons/delete/{id}")
    public String deleteLesson(@PathVariable Long id, @RequestParam Long languageId, Authentication auth) {
        User admin = userService.findByEmail(auth.getName()).orElse(null);
        auditLogService.log(admin.getId(), "Deleted lesson", null);
        lessonService.deleteLesson(id);
        return "redirect:/admin/lessons?languageId=" + languageId;
    }

    @GetMapping("/exercises")
    public String exercisesPage(@RequestParam Long lessonId, Authentication auth, Model model) {
        User admin = userService.findByEmail(auth.getName()).orElse(null);
        Lesson lesson = lessonService.findById(lessonId).orElse(null);
        model.addAttribute("currentPage", "lessons");
        model.addAttribute("user", admin);
        model.addAttribute("lesson", lesson);
        model.addAttribute("exercises", lessonService.findExercisesByLessonId(lessonId));
        if (lesson != null) {
            model.addAttribute("language", languageService.findById(lesson.getLanguageId()).orElse(null));
        }
        return "admin/exercises";
    }

    @PostMapping("/exercises/add")
    public String addExercise(@RequestParam Long lessonId, @RequestParam String type,
                             @RequestParam String question, @RequestParam String correctAnswer,
                             @RequestParam(required = false) String options,
                             @RequestParam Integer points, Authentication auth) {
        User admin = userService.findByEmail(auth.getName()).orElse(null);
        Exercise ex = new Exercise();
        ex.setLessonId(lessonId);
        ex.setType(type);
        ex.setQuestion(question);
        ex.setCorrectAnswer(correctAnswer);
        ex.setOptions(options);
        ex.setPoints(points);
        lessonService.saveExercise(ex);
        auditLogService.log(admin.getId(), "Added exercise to lesson " + lessonId, null);
        return "redirect:/admin/exercises?lessonId=" + lessonId;
    }

    @PostMapping("/exercises/delete/{id}")
    public String deleteExercise(@PathVariable Long id, @RequestParam Long lessonId, Authentication auth) {
        User admin = userService.findByEmail(auth.getName()).orElse(null);
        auditLogService.log(admin.getId(), "Deleted exercise", null);
        lessonService.deleteExercise(id);
        return "redirect:/admin/exercises?lessonId=" + lessonId;
    }
}
