package com.jellmayer.forumhub.api.controller;

import com.jellmayer.forumhub.api.domain.user.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;
    private final UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity<UserDetailDto> create(@RequestBody @Valid CreateUserDto data, UriComponentsBuilder uriBuilder){
        var user = userService.createUser(data);

        var uri = uriBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new UserDetailDto(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailDto> detail(@PathVariable Long id){
        var user = repository.getReferenceById(id);
        return ResponseEntity.ok(new UserDetailDto(user));
    }
}
