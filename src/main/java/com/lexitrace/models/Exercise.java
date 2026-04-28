package com.lexitrace.models;

import jakarta.persistence.*;

@Entity
@Table(name = "exercises", uniqueConstraints = @UniqueConstraint(columnNames = {"lesson_id", "question"}))
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lesson_id", nullable = false)
    private Long lessonId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id", insertable = false, updatable = false)
    private Lesson lesson;

    @Column(nullable = false, length = 30)
    private String type;

    @Column(nullable = false, length = 500)
    private String question;

    @Column(name = "correct_answer", nullable = false, length = 500)
    private String correctAnswer;

    @Column(columnDefinition = "TEXT")
    private String options;

    @Column(nullable = false)
    private Integer points = 10;

    public Exercise() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getLessonId() { return lessonId; }
    public void setLessonId(Long lessonId) { this.lessonId = lessonId; }

    public Lesson getLesson() { return lesson; }
    public void setLesson(Lesson lesson) { this.lesson = lesson; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }

    public String getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }

    public String getOptions() { return options; }
    public void setOptions(String options) { this.options = options; }

    public Integer getPoints() { return points; }
    public void setPoints(Integer points) { this.points = points; }
}
