package com.jellmayer.forumhub.api.domain.topic;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TopicStatus {

    // Status possíveis e os seus valores de exibição.
    UNANSWERED("Aberto"),
    SOLVED("Solucionado"),
    CLOSED("Fechado");

    private final String displayValue;

    // Construtor privado que associa a ‘string’ a cada constante do enum.
    TopicStatus(String displayName) {
        this.displayValue = displayName;
    }

    // Retorna o valor de exibição no JSON
    @JsonValue
    public String getDisplayValue() {
        return displayValue;
    }

    // Converte a string recebida no JSOn o enum correspondente.
    @JsonCreator
    public static TopicStatus fromString(String text) {
        if (text == null) {
            return null;
        }
        for (TopicStatus status : TopicStatus.values()) {
            if (status.displayValue.equalsIgnoreCase(text)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status inválido '" + text + "'. Os valores aceitos são: Aberto, Solucionado, Fechado.");
    }
}
