package com.jellmayer.forumhub.api.controller;

import com.jellmayer.forumhub.api.domain.topic.*;
import com.jellmayer.forumhub.api.domain.user.UserDetailDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/topic")
@RequiredArgsConstructor
public class TopicController {
    private final TopicRepository repository;
    private final TopicService service;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicDetailDto> create(@RequestBody @Valid CreateTopicDto data, UriComponentsBuilder uriBuilder){
        var newTopicDetailDto = service.createTopic(data);

        var uri = uriBuilder.path("/topic/{id}").buildAndExpand(newTopicDetailDto.id()).toUri();

        return ResponseEntity.created(uri).body(newTopicDetailDto);
    }

    @GetMapping
    public ResponseEntity<List<TopicDetailDto>> listAll(){
        var list = repository.findAll().stream().map(TopicDetailDto::new).toList();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TopicDetailDto> detail(@PathVariable Long id){
        var topic = repository.getReferenceById(id);
        return ResponseEntity.ok(new TopicDetailDto(topic));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDetailDto> update(@PathVariable Long id, @RequestBody UpdateTopicDto data){
        var updatedTopicDetailDto = service.updateTopic(id, data);
        return ResponseEntity.ok(updatedTopicDetailDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }
}
