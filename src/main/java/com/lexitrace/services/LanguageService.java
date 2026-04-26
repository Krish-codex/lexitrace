package com.lexitrace.services;

import com.lexitrace.dao.LanguageRepository;
import com.lexitrace.dao.UserLanguageRepository;
import com.lexitrace.models.Language;
import com.lexitrace.models.UserLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private UserLanguageRepository userLanguageRepository;

    public List<Language> findAllLanguages() {
        return languageRepository.findAll();
    }

    public List<Language> findActiveLanguages() {
        return languageRepository.findByIsActiveTrue();
    }

    public Optional<Language> findById(Long id) {
        return languageRepository.findById(id);
    }

    public Language saveLanguage(Language language) {
        return languageRepository.save(language);
    }

    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }

    public void toggleActive(Long id) {
        languageRepository.findById(id).ifPresent(lang -> {
            lang.setIsActive(!lang.getIsActive());
            languageRepository.save(lang);
        });
    }

    // Enrollment
    public boolean isEnrolled(Long userId, Long languageId) {
        return userLanguageRepository.existsByUserIdAndLanguageId(userId, languageId);
    }

    public void enroll(Long userId, Long languageId) {
        if (!userLanguageRepository.existsByUserIdAndLanguageId(userId, languageId)) {
            userLanguageRepository.save(new UserLanguage(userId, languageId));
        }
    }

    @Transactional
    public void unenroll(Long userId, Long languageId) {
        userLanguageRepository.deleteByUserIdAndLanguageId(userId, languageId);
    }

    public List<Language> getEnrolledLanguages(Long userId) {
        return userLanguageRepository.findByUserId(userId).stream()
                .map(ul -> languageRepository.findById(ul.getLanguageId()).orElse(null))
                .filter(lang -> lang != null)
                .collect(Collectors.toList());
    }

    public long getEnrollmentCount(Long languageId) {
        return userLanguageRepository.countByLanguageId(languageId);
    }
}
