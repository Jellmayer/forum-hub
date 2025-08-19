package com.jellmayer.forumhub.api.controller;

import com.jellmayer.forumhub.api.domain.course.Course;
import com.jellmayer.forumhub.api.domain.course.CourseDetailDto;
import com.jellmayer.forumhub.api.domain.course.CourseRepository;
import com.jellmayer.forumhub.api.domain.course.CreateCourseDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<CourseDetailDto> create(@RequestBody @Valid CreateCourseDto data, UriComponentsBuilder uriBuilder){
        var course = new Course(data);
        repository.save(course);

        var uri = uriBuilder.path("/course/{id}").buildAndExpand(course.getId()).toUri();

        return ResponseEntity.created(uri).body(new CourseDetailDto(course));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDetailDto> detail(@PathVariable Long id){
        var course = repository.getReferenceById(id);
        return ResponseEntity.ok(new CourseDetailDto(course));
    }
}
