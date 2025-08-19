package com.jellmayer.forumhub.api.domain.topic;

import com.jellmayer.forumhub.api.domain.course.Course;
import com.jellmayer.forumhub.api.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;
    private LocalDate creationDate;
    private Status status;

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
        this.status = Status.UNANSWERED;
    }
}
