package com.viggad.trackingmoney.controller;

import com.viggad.trackingmoney.dto.request.PurchaseRequest;
import com.viggad.trackingmoney.dto.response.GetPurchaseResponse;
import com.viggad.trackingmoney.service.inter.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/purchase")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<String> createPurchase(
            @RequestPart("file") MultipartFile file,
            @RequestPart("purchase") PurchaseRequest purchase
    ) {

        String response = purchaseService.createPurchase(file, purchase);

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<GetPurchaseResponse> getAllPurchases(@RequestParam(name = "page")int page, @RequestParam(name = "size") int size) {
        return ResponseEntity.ok(purchaseService.getAllPurchases(page, size));
    }


}
