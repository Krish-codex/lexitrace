package com.lexitrace.services;

import com.lexitrace.dao.UserRepository;
import com.lexitrace.dao.UserStreakRepository;
import com.lexitrace.models.User;
import com.lexitrace.models.UserStreak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserStreakRepository userStreakRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(String name, String email, String password, String securityQuestion, String securityAnswer) {
        if (userRepository.existsByEmail(email)) {
            throw new RuntimeException("Email already registered");
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole("USER");
        user.setSecurityQuestion(securityQuestion);
        user.setSecurityAnswer(passwordEncoder.encode(securityAnswer));
        User saved = userRepository.save(user);

        // Create initial streak record
        UserStreak streak = new UserStreak();
        streak.setUserId(saved.getId());
        streak.setCurrentStreak(0);
        streak.setLongestStreak(0);
        streak.setLastActiveDate(LocalDate.now());
        userStreakRepository.save(streak);

        return saved;
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public List<User> searchUsers(String query) {
        return userRepository.findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(query, query);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public void banUser(Long id) {
        userRepository.findById(id).ifPresent(user -> {
            user.setIsBanned(true);
            userRepository.save(user);
        });
    }

    public void unbanUser(Long id) {
        userRepository.findById(id).ifPresent(user -> {
            user.setIsBanned(false);
            userRepository.save(user);
        });
    }

    public void changePassword(Long userId, String newPassword) {
        userRepository.findById(userId).ifPresent(user -> {
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
        });
    }

    public boolean resetPasswordBySecurityQuestion(String email, String answer, String newPassword) {
        Optional<User> optUser = userRepository.findByEmail(email);
        if (optUser.isPresent()) {
            User user = optUser.get();
            if (passwordEncoder.matches(answer, user.getSecurityAnswer())) {
                user.setPassword(passwordEncoder.encode(newPassword));
                userRepository.save(user);
                return true;
            }
        }
        return false;
    }

    public long countUsers() {
        return userRepository.countUsers();
    }

    public long countNewUsersToday() {
        return userRepository.countNewUsersSince(LocalDate.now().atStartOfDay());
    }

    public void updateStreak(Long userId) {
        UserStreak streak = userStreakRepository.findByUserId(userId)
                .orElseGet(() -> {
                    UserStreak s = new UserStreak();
                    s.setUserId(userId);
                    s.setCurrentStreak(0);
                    s.setLongestStreak(0);
                    return s;
                });

        LocalDate today = LocalDate.now();
        LocalDate lastActive = streak.getLastActiveDate();

        if (lastActive == null || lastActive.isBefore(today.minusDays(1))) {
            streak.setCurrentStreak(1);
        } else if (lastActive.equals(today.minusDays(1))) {
            streak.setCurrentStreak(streak.getCurrentStreak() + 1);
        }
        // If lastActive is today, streak remains unchanged

        if (streak.getCurrentStreak() > streak.getLongestStreak()) {
            streak.setLongestStreak(streak.getCurrentStreak());
        }
        streak.setLastActiveDate(today);
        userStreakRepository.save(streak);
    }
}
