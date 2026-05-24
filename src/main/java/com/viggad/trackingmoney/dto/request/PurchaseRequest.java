package com.viggad.trackingmoney.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PurchaseRequest {

    private Long accountId;

    private Long categoryId;

    private String note;

    private double price;
}
