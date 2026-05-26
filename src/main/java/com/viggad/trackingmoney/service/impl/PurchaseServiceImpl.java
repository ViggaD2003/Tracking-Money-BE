package com.viggad.trackingmoney.service.impl;

import com.viggad.trackingmoney.dto.request.PurchaseRequest;
import com.viggad.trackingmoney.dto.response.GetPurchaseResponse;
import com.viggad.trackingmoney.dto.response.PurchaseResponse;
import com.viggad.trackingmoney.exception.AccountNotFound;
import com.viggad.trackingmoney.mapper.PurchaseMapper;
import com.viggad.trackingmoney.model.Account;
import com.viggad.trackingmoney.model.Category;
import com.viggad.trackingmoney.model.Purchase;
import com.viggad.trackingmoney.repository.AccountRepository;
import com.viggad.trackingmoney.repository.CategoryRepository;
import com.viggad.trackingmoney.repository.PurchaseRepository;
import com.viggad.trackingmoney.service.inter.CloudinaryService;
import com.viggad.trackingmoney.service.inter.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;

    private final CloudinaryService cloudinaryService;

    private final AccountRepository accountRepository;

    private final CategoryRepository categoryRepository;

    private final PurchaseMapper purchaseMapper;


    @Override
    public String createPurchase(MultipartFile file, PurchaseRequest purchase) {
        Purchase entity = purchaseMapper.toPurchase(purchase);

        if(purchase.getAccountId() == null){
            throw new RuntimeException("Account id is null");
        }

        if(purchase.getCategoryId() == null){
            throw new RuntimeException("Category id is null");
        }

        Account account = accountRepository.findAccountById(purchase.getAccountId()).orElseThrow(
                () -> new AccountNotFound("Account not found")
        );

        Category category = categoryRepository.findById(purchase.getCategoryId()).orElseThrow(
                () -> new RuntimeException("Category not found")
        );

        entity.setAccount(account);
        entity.setCategory(category);

        String imageUrl = cloudinaryService.uploadImage(file);
        entity.setImageUrl(imageUrl);
        purchaseRepository.save(entity);

        return "Create Purchase Successfully";
    }

    @Override
    public String deletePurchase(Long purchaseId) {
        return "";
    }

    @Override
    public GetPurchaseResponse getAllPurchases(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        Page<Purchase> purchasePage =
                purchaseRepository.findAll(pageable);

        List<PurchaseResponse> items =
                purchasePage.getContent()
                        .stream()
                        .map(purchaseMapper::toPurchaseRequest)
                        .toList();

        return GetPurchaseResponse.builder()
                .items(items)
                .totalMoney(calculateTotalMoney(items))
                .page(purchasePage.getNumber())
                .size(purchasePage.getSize())
                .totalPages(purchasePage.getTotalPages())
                .totalItems(purchasePage.getTotalElements())
                .build();
    }


    private double calculateTotalMoney(List<PurchaseResponse> list){
        double total = 0;
        for (PurchaseResponse x : list) {
            total += x.getPrice();
        }

        return total;
    }
}
