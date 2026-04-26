package com.lexitrace.admin;

import com.lexitrace.models.User;
import com.lexitrace.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminUserController {

    @Autowired private UserService userService;
    @Autowired private AuditLogService auditLogService;

    private User getAdmin(Authentication auth) {
        return userService.findByEmail(auth.getName()).orElse(null);
    }

    @GetMapping("/users")
    public String usersPage(@RequestParam(required = false) String search, Authentication auth, Model model) {
        User admin = getAdmin(auth);
        List<User> users;
        if (search != null && !search.isBlank()) {
            users = userService.searchUsers(search);
            model.addAttribute("search", search);
        } else {
            users = userService.findAllUsers();
        }
        model.addAttribute("currentPage", "users");
        model.addAttribute("user", admin);
        model.addAttribute("users", users);
        return "admin/users";
    }

    @PostMapping("/users/ban/{id}")
    public String banUser(@PathVariable Long id, Authentication auth) {
        User admin = getAdmin(auth);
        userService.banUser(id);
        auditLogService.log(admin.getId(), "Banned user", id);
        return "redirect:/admin/users";
    }

    @PostMapping("/users/unban/{id}")
    public String unbanUser(@PathVariable Long id, Authentication auth) {
        User admin = getAdmin(auth);
        userService.unbanUser(id);
        auditLogService.log(admin.getId(), "Unbanned user", id);
        return "redirect:/admin/users";
    }

    @PostMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id, Authentication auth) {
        User admin = getAdmin(auth);
        auditLogService.log(admin.getId(), "Deleted user", id);
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

    @PostMapping("/users/reset-password/{id}")
    public String resetPassword(@PathVariable Long id, Authentication auth) {
        User admin = getAdmin(auth);
        userService.changePassword(id, "password123");
        auditLogService.log(admin.getId(), "Reset password for user", id);
        return "redirect:/admin/users";
    }
}
