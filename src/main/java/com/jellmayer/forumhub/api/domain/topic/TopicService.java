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

    public TopicDetailDto createTopic(CreateTopicDto newTopicDto){
        User author = userRepository.findById(newTopicDto.authorId())
                .orElseThrow(() -> new EntityNotFoundException("Autor não encontrado com o ID: " + newTopicDto.authorId()));

        Course course = courseRepository.findById(newTopicDto.courseId())
                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado com o ID: " + newTopicDto.courseId()));

        Topic newTopic = new Topic(newTopicDto.title(), newTopicDto.message(), author, course);

        return new TopicDetailDto(topicRepository.save(newTopic));

    }

    public TopicDetailDto updateTopic(Long id, UpdateTopicDto updateTopicDto){
        Topic topic = topicRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado com o ID: " + id));

        TopicStatus topicStatus = TopicStatus.fromString(updateTopicDto.status());

        topic.updateInfo(updateTopicDto.title(), updateTopicDto.message(), topicStatus);

        return new TopicDetailDto(topic);
    }

    public void deleteTopic(Long id) {
        if (!topicRepository.existsById(id)){
            throw new EntityNotFoundException("Tópico não encontrado com o ID: " + id);
        }
        topicRepository.deleteById(id);
    }
}
