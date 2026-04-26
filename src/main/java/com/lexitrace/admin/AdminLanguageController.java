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
public class AdminLanguageController {

    @Autowired private UserService userService;
    @Autowired private LanguageService languageService;
    @Autowired private AuditLogService auditLogService;

    @GetMapping("/languages")
    public String languagesPage(Authentication auth, Model model) {
        User admin = userService.findByEmail(auth.getName()).orElse(null);
        model.addAttribute("currentPage", "languages");
        model.addAttribute("user", admin);
        model.addAttribute("languages", languageService.findAllLanguages());
        return "admin/languages";
    }

    @PostMapping("/languages/add")
    public String addLanguage(@RequestParam String name, @RequestParam String code,
                             @RequestParam String flagEmoji, Authentication auth) {
        User admin = userService.findByEmail(auth.getName()).orElse(null);
        Language lang = new Language(name, code, flagEmoji);
        languageService.saveLanguage(lang);
        auditLogService.log(admin.getId(), "Added language: " + name, null);
        return "redirect:/admin/languages";
    }

    @PostMapping("/languages/toggle/{id}")
    public String toggleLanguage(@PathVariable Long id, Authentication auth) {
        User admin = userService.findByEmail(auth.getName()).orElse(null);
        languageService.toggleActive(id);
        auditLogService.log(admin.getId(), "Toggled language active status", null);
        return "redirect:/admin/languages";
    }

    @PostMapping("/languages/delete/{id}")
    public String deleteLanguage(@PathVariable Long id, Authentication auth) {
        User admin = userService.findByEmail(auth.getName()).orElse(null);
        auditLogService.log(admin.getId(), "Deleted language", null);
        languageService.deleteLanguage(id);
        return "redirect:/admin/languages";
    }
}
