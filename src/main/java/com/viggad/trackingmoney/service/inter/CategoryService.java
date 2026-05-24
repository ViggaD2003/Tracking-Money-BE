package com.viggad.trackingmoney.service.inter;

import com.viggad.trackingmoney.dto.request.CategoryRequest;
import com.viggad.trackingmoney.dto.response.CategoryResponse;

import java.util.List;


public interface CategoryService {

    String createCategory(CategoryRequest categoryRequest);

    List<CategoryResponse> getAllCategories(Long accountId);
}
