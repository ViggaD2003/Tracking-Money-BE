package com.viggad.trackingmoney.controller;


import com.viggad.trackingmoney.dto.request.CategoryRequest;
import com.viggad.trackingmoney.dto.response.CategoryResponse;
import com.viggad.trackingmoney.service.inter.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryContoller {

    private final CategoryService categoryService;

    @GetMapping("/{accountId}")
    public ResponseEntity<List<CategoryResponse>> findAllByAccountId(@PathVariable("accountId") Long accountId) {
        return ResponseEntity.ok(categoryService.getAllCategories(accountId));
    }

    @PostMapping
    public ResponseEntity<String> createNewCategory(@RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.ok(categoryService.createCategory(categoryRequest));
    }


}
