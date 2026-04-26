package com.lexitrace.user;

import com.lexitrace.models.*;
import com.lexitrace.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@Controller
@RequestMapping("/user")
public class UserLanguageController {

    @Autowired private UserService userService;
    @Autowired private LanguageService languageService;
    @Autowired private LessonService lessonService;
    @Autowired private NotificationService notificationService;

    private User getCurrentUser(Authentication auth) {
        return userService.findByEmail(auth.getName()).orElse(null);
    }

    @GetMapping("/languages")
    public String languagesPage(Authentication auth, Model model) {
        User user = getCurrentUser(auth);
        if (user == null) return "redirect:/login";

        List<Language> languages = languageService.findActiveLanguages();
        Map<Long, Boolean> enrollmentMap = new HashMap<>();
        Map<Long, Double> progressMap = new HashMap<>();

        for (Language lang : languages) {
            enrollmentMap.put(lang.getId(), languageService.isEnrolled(user.getId(), lang.getId()));
            progressMap.put(lang.getId(), lessonService.getLanguageProgress(user.getId(), lang.getId()));
        }

        model.addAttribute("currentPage", "languages");
        model.addAttribute("user", user);
        model.addAttribute("languages", languages);
        model.addAttribute("enrollmentMap", enrollmentMap);
        model.addAttribute("progressMap", progressMap);
        model.addAttribute("unreadCount", notificationService.getUnreadCount(user.getId()));
        return "user/languages";
    }

    @PostMapping("/languages/enroll/{languageId}")
    public String enroll(@PathVariable Long languageId, Authentication auth) {
        User user = getCurrentUser(auth);
        if (user != null) {
            languageService.enroll(user.getId(), languageId);
            notificationService.createNotification(user.getId(), "You enrolled in a new language! 🎉");
        }
        return "redirect:/user/languages";
    }

    @PostMapping("/languages/unenroll/{languageId}")
    public String unenroll(@PathVariable Long languageId, Authentication auth) {
        User user = getCurrentUser(auth);
        if (user != null) languageService.unenroll(user.getId(), languageId);
        return "redirect:/user/languages";
    }
}
