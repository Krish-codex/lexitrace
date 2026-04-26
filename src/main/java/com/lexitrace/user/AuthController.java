package com.lexitrace.user;

import com.lexitrace.models.User;
import com.lexitrace.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        if (error != null) model.addAttribute("error", "Invalid email or password");
        if (logout != null) model.addAttribute("message", "Logged out successfully");
        return "login";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String name, @RequestParam String email,
                              @RequestParam String password, @RequestParam String confirmPassword,
                              @RequestParam String securityQuestion, @RequestParam String securityAnswer,
                              Model model) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match");
            return "register";
        }
        try {
            userService.registerUser(name, email, password, securityQuestion, securityAnswer);
            return "redirect:/login?registered=true";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    @GetMapping("/forgot-password")
    public String forgotPasswordPage() {
        return "forgot-password";
    }

    @PostMapping("/reset-password")
    public String resetPassword(@RequestParam String email, @RequestParam String securityAnswer,
                               @RequestParam String newPassword, Model model) {
        boolean success = userService.resetPasswordBySecurityQuestion(email, securityAnswer, newPassword);
        if (success) {
            return "redirect:/login?reset=true";
        } else {
            model.addAttribute("error", "Invalid email or security answer");
            return "forgot-password";
        }
    }
}
