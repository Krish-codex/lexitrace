# 🌐 LexiTrace — Language Learning Platform

A full-stack Java/Spring Boot language learning web application inspired by Duolingo. Learn French, Spanish, and Japanese through interactive lessons with MCQ, fill-in-the-blank, matching, and translation exercises.

## ✨ Features

### User Panel
- **Dashboard** — Streak tracking, XP progress, enrolled languages, leaderboard, badges
- **Language Browser** — Enroll/unenroll with progress rings
- **Lesson Flow** — Sequential unlock, 4 exercise types, scoring, time tracking
- **Analytics** — XP charts, accuracy per language, activity heatmap, achievements
- **Profile** — Edit info, change password, view badges & stats
- **Notifications** — Real-time notification bell with read/unread

### Admin Panel
- **Dashboard** — Total users, lessons, exercises, registration trends, language popularity
- **User Management** — Search, ban/unban, delete, reset password
- **Language Management** — Add/delete languages, toggle active status
- **Lesson & Exercise Management** — Full CRUD for lessons and exercises
- **Analytics** — XP distribution, completion rates, drop-off analysis, top users
- **Audit Logs** — Complete admin action history

## 🛠 Tech Stack

| Layer | Technology |
|-------|-----------|
| Language | Java 17+ |
| Framework | Spring Boot 3.2.5 |
| Database | H2 (dev) / MySQL 8.x (prod) |
| ORM | Hibernate / Spring Data JPA |
| UI | Thymeleaf + Custom CSS |
| Charts | Chart.js |
| Auth | Spring Security + BCrypt |
| Build | Maven |

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.8+
- (Optional) MySQL 8.x for production

### Run with H2 (Development — No DB Setup Required)

```bash
cd LexiTrace
mvn spring-boot:run
```

The app starts at **http://localhost:8080**

### Run with MySQL (Production)

1. Create a MySQL database:
```sql
CREATE DATABASE lexitrace;
```

2. Edit `src/main/resources/application.properties`:
   - Comment out the H2 section
   - Uncomment the MySQL section
   - Set your MySQL username/password

3. Run:
```bash
mvn spring-boot:run
```

## 🔑 Default Credentials

| Role | Email | Password |
|------|-------|----------|
| Admin | admin@lexitrace.com | admin123 |
| User | user@lexitrace.com | user123 |

## 📁 Project Structure

```
LexiTrace/
├── src/main/java/com/lexitrace/
│   ├── admin/          # Admin controllers
│   ├── user/           # User controllers + auth
│   ├── models/         # JPA entities + DTOs
│   ├── dao/            # Spring Data JPA repositories
│   ├── services/       # Business logic + analytics
│   └── utils/          # Security config + data init
├── src/main/resources/
│   ├── templates/      # Thymeleaf HTML templates
│   │   ├── admin/      # Admin panel pages
│   │   ├── user/       # User panel pages
│   │   └── fragments/  # Shared layout fragments
│   ├── static/css/     # Stylesheets
│   └── db/             # Schema + seed data SQL
├── pom.xml
└── README.md
```

## 🌍 Seed Data

- **3 Languages**: French 🇫🇷, Spanish 🇪🇸, Japanese 🇯🇵
- **15 Lessons** (5 per language)
- **60 Exercises** (3-5 per lesson, mixed types)

## 📜 License

MIT License — Feel free to use, modify, and distribute.
