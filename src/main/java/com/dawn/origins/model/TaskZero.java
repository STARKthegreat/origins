package com.dawn.origins.model;

import java.time.Instant;

public record TaskZero(
        String email,
        Instant current_datetime,
        String github_url) {

}
