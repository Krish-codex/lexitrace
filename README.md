# 🌐 LexiTrace — Language Learning Platform

LexiTrace is a premium, full-stack language learning ecosystem built with **Spring Boot 3**. It offers a professional-grade experience for both students and administrators, featuring interactive exercises, rich analytics, and a stunning modern dark-mode interface.

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17%2B-blue)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-orange)](LICENSE)

---

## ✨ Features

### 🎓 Student Experience
- **Interactive Dashboard** — Real-time tracking of streaks, total XP, and weekly progress charts.
- **Language Hub** — Browse and enroll in 6 global languages with visual progress indicators.
- **Progressive Learning** — Lessons unlock sequentially. Complete exercises to earn XP and move forward.
- **Dynamic Exercises** — Mix of MCQ, Fill-in-the-blank, Translation, and Matching questions.
- **Performance Analytics** — Detailed breakdowns of accuracy, completion rates, and platform-wide rankings.
- **Gamification** — Earn badges and climb the global leaderboard.

### 🛡️ Administrator Suite
- **Control Center** — Overview of platform growth, popular languages, and registration trends.
- **Content Management** — Full CRUD control over Languages, Lessons, and Exercise banks.
- **User Governance** — Manage user accounts, handle bans, and monitor activity.
- **Audit Logging** — Every admin action is tracked for maximum security and accountability.
- **Deep Analytics** — Monitor lesson drop-off rates and user engagement metrics.

---

## 🛠 Tech Stack

| Component | Technology |
| :--- | :--- |
| **Backend** | Java 17+, Spring Boot 3.2.5 |
| **Persistence** | Spring Data JPA (Hibernate) |
| **Database** | H2 (Dev/File), MySQL (Production Ready) |
| **Security** | Spring Security + BCrypt + CSRF Protection |
| **Frontend** | Thymeleaf + Modern Vanilla CSS (Glassmorphism) |
| **Visualization** | Chart.js 4.x |
| **Build Tool** | Maven |

---

## 🚀 Getting Started

### 1. Prerequisites
- **Java 17** or higher installed.
- **Maven 3.8+** installed.

### 2. Clone and Run
```bash
# Clone the repository
git clone https://github.com/Krish-codex/lexitrace.git

# Enter directory
cd LexiTrace

# Run the application
mvn spring-boot:run
```

The application will be available at: **[http://localhost:8080](http://localhost:8080)**

---

## 🔑 Access Credentials

| Role | Email | Password |
| :--- | :--- | :--- |
| **Administrator** | `admin@lexitrace.com` | `admin123` |
| **Demo User** | `user@lexitrace.com` | `user123` |

---

## 🌍 Built-in Content
LexiTrace comes pre-seeded with high-quality learning content:
- **6 Languages**: French 🇫🇷, Spanish 🇪🇸, Japanese 🇯🇵, German 🇩🇪, Italian 🇮🇹, Korean 🇰🇷.
- **30 Core Lessons**: 5 levels per language.
- **98 Interactive Exercises**: Covering vocabulary, grammar, and travel phrases.

---

## 💎 Recent Refinements
- **Security Hardening**: Replaced vulnerable GET-based logout with POST+CSRF protection.
- **Data Integrity**: Implemented unique constraints on lessons and exercises to prevent redundancy during re-seeding.
- **Content Expansion**: Doubled the language offerings from 3 to 6.
- **Bug Fixes**: Resolved template rendering issues and session management errors.

---

## 📁 Repository Structure
```text
LexiTrace/
├── src/main/java/com/lexitrace/
│   ├── admin/          # Admin portal controllers
│   ├── user/           # Student portal & Auth logic
│   ├── models/         # JPA Entities & Data models
│   ├── dao/            # Data Access Objects (Repositories)
│   ├── services/       # Core Business Logic & Analytics
│   └── utils/          # Security & Data Initialization
├── src/main/resources/
│   ├── templates/      # Thymeleaf UI Templates
│   ├── static/css/     # Modern Design System (CSS)
│   └── db/             # Database Schema & Seed Data
└── pom.xml
```

---

## 📜 License
Distributed under the **MIT License**. See `LICENSE` for more information.
