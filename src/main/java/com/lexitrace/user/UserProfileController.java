package com.lexitrace.user;

import com.lexitrace.models.User;
import com.lexitrace.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserProfileController {

    @Autowired private UserService userService;
    @Autowired private LanguageService languageService;
    @Autowired private AnalyticsService analyticsService;
    @Autowired private NotificationService notificationService;
    @Autowired private PasswordEncoder passwordEncoder;

    private User getCurrentUser(Authentication auth) {
        return userService.findByEmail(auth.getName()).orElse(null);
    }

    @GetMapping("/profile")
    public String profilePage(Authentication auth, Model model) {
        User user = getCurrentUser(auth);
        if (user == null) return "redirect:/login";

        model.addAttribute("currentPage", "profile");
        model.addAttribute("user", user);
        model.addAttribute("enrolledLanguages", languageService.getEnrolledLanguages(user.getId()));
        model.addAttribute("totalXP", analyticsService.getTotalXP(user.getId()));
        model.addAttribute("badges", analyticsService.getUserBadges(user.getId()));
        model.addAttribute("streak", analyticsService.getUserStreak(user.getId()));
        model.addAttribute("topUsers", analyticsService.getPlatformTopUsers(100));
        model.addAttribute("unreadCount", notificationService.getUnreadCount(user.getId()));
        return "user/profile";
    }

    @PostMapping("/profile/update")
    public String updateProfile(@RequestParam String name, @RequestParam String email,
                               Authentication auth, Model model) {
        User user = getCurrentUser(auth);
        if (user == null) return "redirect:/login";
        user.setName(name);
        user.setEmail(email);
        userService.updateUser(user);
        return "redirect:/user/profile?updated=true";
    }

    @PostMapping("/profile/change-password")
    public String changePassword(@RequestParam String currentPassword,
                                @RequestParam String newPassword,
                                Authentication auth, Model model) {
        User user = getCurrentUser(auth);
        if (user == null) return "redirect:/login";
        if (!passwordEncoder.matches(currentPassword, user.getPassword())) {
            return "redirect:/user/profile?error=wrongpassword";
        }
        userService.changePassword(user.getId(), newPassword);
        return "redirect:/user/profile?passwordChanged=true";
    }

    @GetMapping("/notifications")
    public String notificationsPage(Authentication auth, Model model) {
        User user = getCurrentUser(auth);
        if (user == null) return "redirect:/login";
        model.addAttribute("currentPage", "notifications");
        model.addAttribute("user", user);
        model.addAttribute("notifications", notificationService.getUserNotifications(user.getId()));
        model.addAttribute("unreadCount", notificationService.getUnreadCount(user.getId()));
        return "user/notifications";
    }

    @PostMapping("/notifications/read/{id}")
    public String markAsRead(@PathVariable Long id, Authentication auth) {
        notificationService.markAsRead(id);
        return "redirect:/user/notifications";
    }

    @PostMapping("/notifications/read-all")
    public String markAllAsRead(Authentication auth) {
        User user = getCurrentUser(auth);
        if (user != null) notificationService.markAllAsRead(user.getId());
        return "redirect:/user/notifications";
    }
}
