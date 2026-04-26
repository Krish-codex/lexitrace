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
public class AdminAnalyticsController {

    @Autowired private UserService userService;
    @Autowired private AnalyticsService analyticsService;

    @GetMapping("/analytics")
    public String analyticsPage(Authentication auth, Model model) {
        User admin = userService.findByEmail(auth.getName()).orElse(null);
        model.addAttribute("currentPage", "analytics");
        model.addAttribute("user", admin);
        model.addAttribute("xpDistribution", analyticsService.getPlatformXPDistribution());
        model.addAttribute("topUsers", analyticsService.getPlatformTopUsers(10));
        model.addAttribute("completionRates", analyticsService.getCompletionRatesPerLesson());
        model.addAttribute("languagePopularity", analyticsService.getLanguagePopularity());
        model.addAttribute("dropOff", analyticsService.getDropOffAnalysis());
        return "admin/analytics";
    }
}
