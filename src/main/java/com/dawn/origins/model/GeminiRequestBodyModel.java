package com.dawn.origins.model;

import java.util.List;

public record GeminiRequestBodyModel(Content contents) {
    public record Content(List<Part> parts) {
    }

    public record Part(String text) {
    }
}
