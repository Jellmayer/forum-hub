package com.jellmayer.forumhub.api.domain.topic;

import com.jellmayer.forumhub.api.domain.course.Course;
import com.jellmayer.forumhub.api.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;
    private LocalDate creationDate;

    @Enumerated(EnumType.STRING)
    private TopicStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    public Topic(String title, String message, User author, Course course) {
        this.title = title;
        this.message = message;
        this.author = author;
        this.course = course;
        this.creationDate = LocalDate.now();
        this.status = TopicStatus.UNANSWERED;
    }

    public void updateInfo(String title, String message, TopicStatus status) {
        if (title != null && !title.isBlank()) {
            this.title = title;
        }
        if (message != null && !message.isBlank()) {
            this.message = message;
        }
        if (status != null) {
            this.status = status;
        }
    }
}
