package com.viggad.trackingmoney.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchaseResponse {
    private Long id;

    private String imageUrl;

    private String note;

    private double price;

    private CategoryResponse categoryResponse;
}
