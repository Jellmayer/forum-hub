package com.jellmayer.forumhub.api.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public User createUser(CreateUserDto createUserDto) {
        var hashedPassword = passwordEncoder.encode(createUserDto.password());

        var newUser = new User(null, createUserDto.name(), createUserDto.email(), hashedPassword);
        return userRepository.save(newUser);
    }
}
