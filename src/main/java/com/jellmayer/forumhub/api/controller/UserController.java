package com.jellmayer.forumhub.api.controller;

import com.jellmayer.forumhub.api.domain.user.CreateUserDto;
import com.jellmayer.forumhub.api.domain.user.User;
import com.jellmayer.forumhub.api.domain.user.UserDetailDto;
import com.jellmayer.forumhub.api.domain.user.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<UserDetailDto> create(@RequestBody @Valid CreateUserDto data, UriComponentsBuilder uriBuilder){
        var user = new User(data);
        repository.save(user);

        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new UserDetailDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailDto> detail(@PathVariable Long id){
        var user = repository.getReferenceById(id);
        return ResponseEntity.ok(new UserDetailDto(user));
    }
}
