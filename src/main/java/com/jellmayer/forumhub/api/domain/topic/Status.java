package com.jellmayer.forumhub.api.domain.topic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    UNANSWERED,
    SOLVED,
    CLOSED
}
