package com.viggad.trackingmoney.service.impl;

import com.viggad.trackingmoney.dto.request.CategoryRequest;
import com.viggad.trackingmoney.dto.response.CategoryResponse;
import com.viggad.trackingmoney.exception.AccountNotFound;
import com.viggad.trackingmoney.mapper.CategoryMapper;
import com.viggad.trackingmoney.model.Account;
import com.viggad.trackingmoney.model.Category;
import com.viggad.trackingmoney.repository.AccountRepository;
import com.viggad.trackingmoney.repository.CategoryRepository;
import com.viggad.trackingmoney.service.inter.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    private final CategoryMapper mapper;

    private final AccountRepository accountRepository;


    @Override
    public String createCategory(CategoryRequest categoryRequest) {
        Category category = mapper.toCategory(categoryRequest);
        category.setDefault(true);

        Account account = accountRepository.findAccountById(categoryRequest.getAccountId()).orElseThrow(() -> new AccountNotFound("Account not found"));

        category.setAccount(account);

        repository.save(category);
        return "Create category successful";
    }

    @Override
    public List<CategoryResponse> getAllCategories(Long accountId) {
        if(accountId == null) {
            throw new RuntimeException("Account id is null");
        }

        if (!accountRepository.existsById(accountId)) {
            throw new RuntimeException("Account not found");
        }

        List<Category> categories = repository.findByAccountId(accountId);

        return categories.stream().map(mapper::toCategoryResponse).collect(Collectors.toList());
    }


}
