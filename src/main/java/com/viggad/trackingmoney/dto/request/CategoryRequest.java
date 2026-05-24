package com.viggad.trackingmoney.dto.request;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CategoryRequest {

    private Long accountId;

    private String name;

    private String icon;

    private String color;
}
