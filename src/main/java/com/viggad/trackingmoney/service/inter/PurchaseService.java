package com.viggad.trackingmoney.service.inter;

import com.viggad.trackingmoney.dto.request.PurchaseRequest;
import com.viggad.trackingmoney.dto.response.GetPurchaseResponse;
import org.springframework.web.multipart.MultipartFile;

public interface PurchaseService {

    String createPurchase(MultipartFile file, PurchaseRequest purchase);

    String deletePurchase(Long purchaseId);

    GetPurchaseResponse getAllPurchases(int page, int size);
}
