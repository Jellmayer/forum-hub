package com.jellmayer.forumhub.api.domain.topic;

import java.time.LocalDate;

public record TopicDetailDto(Long id, String title, String message, LocalDate creationDate, TopicStatus status, Long author_id, Long course_id) {
    public TopicDetailDto(Topic topic){
        this(topic.getId(), topic.getTitle(), topic.getMessage(), topic.getCreationDate(),topic.getStatus(),topic.getAuthor().getId(), topic.getCourse().getId());
    }
}
