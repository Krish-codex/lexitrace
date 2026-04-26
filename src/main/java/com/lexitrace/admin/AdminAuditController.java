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
public class AdminAuditController {

    @Autowired private UserService userService;
    @Autowired private AuditLogService auditLogService;

    @GetMapping("/audit-logs")
    public String auditLogsPage(Authentication auth, Model model) {
        User admin = userService.findByEmail(auth.getName()).orElse(null);
        model.addAttribute("currentPage", "audit-logs");
        model.addAttribute("user", admin);
        model.addAttribute("logs", auditLogService.getAllLogs());
        return "admin/audit-logs";
    }
}
