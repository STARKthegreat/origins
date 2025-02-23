package com.dawn.origins.model;

import java.util.List;

public record DataTicker(
        Descriptions descriptions,
        String integration_type,
        List<String> key_features,
        String author,
        List<Setting> settings,
        String tick_url) {

}
