package com.lexitrace.user;

import com.lexitrace.models.User;
import com.lexitrace.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserAnalyticsController {

    @Autowired private UserService userService;
    @Autowired private AnalyticsService analyticsService;
    @Autowired private NotificationService notificationService;

    private User getCurrentUser(Authentication auth) {
        return userService.findByEmail(auth.getName()).orElse(null);
    }

    @GetMapping("/analytics")
    public String analyticsPage(Authentication auth, Model model) {
        User user = getCurrentUser(auth);
        if (user == null) return "redirect:/login";

        model.addAttribute("currentPage", "analytics");
        model.addAttribute("user", user);
        model.addAttribute("weeklyXP", analyticsService.getUserWeeklyXP(user.getId()));
        model.addAttribute("lessonsPerLang", analyticsService.getLessonsCompletedPerLanguage(user.getId()));
        model.addAttribute("accuracy", analyticsService.getUserAccuracyByLanguage(user.getId()));
        model.addAttribute("totalTime", analyticsService.getTotalTimeSpent(user.getId()));
        model.addAttribute("totalXP", analyticsService.getTotalXP(user.getId()));
        model.addAttribute("streak", analyticsService.getUserStreak(user.getId()));
        model.addAttribute("activityCalendar", analyticsService.getActivityCalendar(user.getId()));
        model.addAttribute("badges", analyticsService.getUserBadges(user.getId()));
        model.addAttribute("unreadCount", notificationService.getUnreadCount(user.getId()));
        return "user/analytics";
    }
}
