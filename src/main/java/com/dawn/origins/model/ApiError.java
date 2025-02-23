package com.dawn.origins.model;

public record ApiError(
        String message,
        String error,
        int status,
        String timestamp
) {

}
