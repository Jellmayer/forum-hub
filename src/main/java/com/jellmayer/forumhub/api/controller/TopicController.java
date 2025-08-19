package com.jellmayer.forumhub.api.controller;

import com.jellmayer.forumhub.api.domain.topic.CreateTopicDto;
import com.jellmayer.forumhub.api.domain.topic.TopicDetailDto;
import com.jellmayer.forumhub.api.domain.topic.TopicRepository;
import com.jellmayer.forumhub.api.domain.topic.TopicService;
import com.jellmayer.forumhub.api.domain.user.UserDetailDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicRepository repository;

    @Autowired
    private TopicService service;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicDetailDto> create(@RequestBody @Valid CreateTopicDto data, UriComponentsBuilder uriBuilder){
        var newTopic = service.createTopic(data);

        var uri = uriBuilder.path("/topic/{id}").buildAndExpand(newTopic.getId()).toUri();

        return ResponseEntity.created(uri).body(new TopicDetailDto(newTopic));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDetailDto> detail(@PathVariable Long id){
        var topic = repository.getReferenceById(id);
        return ResponseEntity.ok(new TopicDetailDto(topic));
    }
}
