package com.viggad.trackingmoney.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GetPurchaseResponse {
    private List<PurchaseResponse> items;

    private int page;

    private int size;

    private int totalPages;

    private long totalItems;

    private double totalMoney;
}
