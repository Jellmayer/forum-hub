package com.jellmayer.forumhub.api.domain.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationDto(
        @NotBlank
        @Email
        String email,

        @NotBlank
        String password
) {}
