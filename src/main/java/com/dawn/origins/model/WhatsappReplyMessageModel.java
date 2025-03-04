package com.dawn.origins.model;

public record WhatsappReplyMessageModel(
        String messaging_product,
        String recipient_type,
        String to,
        Context context,
        String type,
        Text text) {
    public record Context(String message_id) {
    }

    public record Text(boolean preview_url, String body) {
    }

}
