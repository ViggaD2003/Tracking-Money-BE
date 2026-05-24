package com.viggad.trackingmoney.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TokenType {
    ACCESS_TOKEN("access_token"),
    REFRESH_TOKEN("refresh_token");
    private final String value;
}
