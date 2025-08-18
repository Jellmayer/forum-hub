package com.jellmayer.forumhub.api.domain.course;

import jakarta.validation.constraints.NotBlank;

public record CreateCourseDto(
        @NotBlank
        String name,

        @NotBlank
        String category) {
}
