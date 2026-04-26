package com.lexitrace.utils;

import com.lexitrace.dao.UserRepository;
import com.lexitrace.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        // Ensure admin user exists with properly hashed password
        if (userRepository.findByEmail("admin@lexitrace.com").isEmpty()) {
            User admin = new User();
            admin.setName("Admin");
            admin.setEmail("admin@lexitrace.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole("ADMIN");
            admin.setSecurityQuestion("What is your favorite color?");
            admin.setSecurityAnswer(passwordEncoder.encode("blue"));
            userRepository.save(admin);
        } else {
            // Update password hash for existing admin
            User admin = userRepository.findByEmail("admin@lexitrace.com").get();
            if (!admin.getPassword().startsWith("$2a$")) {
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setSecurityAnswer(passwordEncoder.encode("blue"));
                userRepository.save(admin);
            }
        }

        // Ensure demo user exists
        if (userRepository.findByEmail("user@lexitrace.com").isEmpty()) {
            User demo = new User();
            demo.setName("Demo User");
            demo.setEmail("user@lexitrace.com");
            demo.setPassword(passwordEncoder.encode("user123"));
            demo.setRole("USER");
            demo.setSecurityQuestion("What is your pet name?");
            demo.setSecurityAnswer(passwordEncoder.encode("buddy"));
            userRepository.save(demo);
        } else {
            User demo = userRepository.findByEmail("user@lexitrace.com").get();
            if (!demo.getPassword().startsWith("$2a$")) {
                demo.setPassword(passwordEncoder.encode("user123"));
                demo.setSecurityAnswer(passwordEncoder.encode("buddy"));
                userRepository.save(demo);
            }
        }
    }
}
