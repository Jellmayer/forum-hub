package com.jellmayer.forumhub.api.domain.user;

public record UserDetailDto(Long id, String name, String email, String password) {
    public UserDetailDto(User user){
        this(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }
}
