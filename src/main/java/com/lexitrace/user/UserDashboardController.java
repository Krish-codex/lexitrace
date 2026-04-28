package com.lexitrace.user;

import com.lexitrace.models.*;
import com.lexitrace.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserDashboardController {

    @Autowired private UserService userService;
    @Autowired private LanguageService languageService;
    @Autowired private LessonService lessonService;
    @Autowired private AnalyticsService analyticsService;
    @Autowired private NotificationService notificationService;

    private User getCurrentUser(Authentication auth) {
        return userService.findByEmail(auth.getName()).orElse(null);
    }

    @GetMapping("/dashboard")
    public String dashboard(Authentication auth, Model model) {
        User user = getCurrentUser(auth);
        if (user == null) return "redirect:/login";

        model.addAttribute("currentPage", "dashboard");
        model.addAttribute("user", user);
        model.addAttribute("streak", analyticsService.getUserStreak(user.getId()));
        model.addAttribute("totalXP", analyticsService.getTotalXP(user.getId()));
        model.addAttribute("enrolledLanguages", languageService.getEnrolledLanguages(user.getId()));
        model.addAttribute("lastLesson", lessonService.getLastLesson(user.getId()));
        model.addAttribute("topUsers", analyticsService.getPlatformTopUsers(5));
        model.addAttribute("weeklyXP", analyticsService.getUserWeeklyXP(user.getId()));
        model.addAttribute("unreadCount", notificationService.getUnreadCount(user.getId()));
        model.addAttribute("badges", analyticsService.getUserBadges(user.getId()));
        return "user/dashboard";
    }
}
