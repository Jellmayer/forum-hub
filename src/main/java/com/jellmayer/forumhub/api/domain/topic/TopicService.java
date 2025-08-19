package com.jellmayer.forumhub.api.domain.topic;

import com.jellmayer.forumhub.api.domain.course.Course;
import com.jellmayer.forumhub.api.domain.course.CourseRepository;
import com.jellmayer.forumhub.api.domain.user.User;
import com.jellmayer.forumhub.api.domain.user.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Topic createTopic(CreateTopicDto topicDto){
        User author = userRepository.findById(topicDto.authorId())
                .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado com o ID: " + topicDto.authorId()));

        Course course = courseRepository.findById(topicDto.courseId())
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com o ID: " + topicDto.courseId()));

        Topic newTopic = new Topic(topicDto.title(), topicDto.message(), author, course);

        return topicRepository.save(newTopic);

    }
}
