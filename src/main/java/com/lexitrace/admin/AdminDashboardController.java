package com.lexitrace.admin;

import com.lexitrace.models.User;
import com.lexitrace.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminDashboardController {

    @Autowired private UserService userService;
    @Autowired private LessonService lessonService;
    @Autowired private AnalyticsService analyticsService;

    @GetMapping("/dashboard")
    public String dashboard(Authentication auth, Model model) {
        User admin = userService.findByEmail(auth.getName()).orElse(null);
        model.addAttribute("currentPage", "dashboard");
        model.addAttribute("user", admin);
        model.addAttribute("totalUsers", userService.countUsers());
        model.addAttribute("activeToday", userService.countNewUsersToday());
        model.addAttribute("totalLessons", lessonService.countAllLessons());
        model.addAttribute("totalExercises", lessonService.countAllExercises());
        model.addAttribute("registrations", analyticsService.getNewRegistrations());
        model.addAttribute("languagePopularity", analyticsService.getLanguagePopularity());
        model.addAttribute("topUsers", analyticsService.getPlatformTopUsers(5));
        return "admin/dashboard";
    }
}
