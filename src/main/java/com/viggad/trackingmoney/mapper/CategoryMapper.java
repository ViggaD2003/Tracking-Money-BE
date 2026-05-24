package com.viggad.trackingmoney.mapper;

import com.viggad.trackingmoney.dto.request.CategoryRequest;
import com.viggad.trackingmoney.dto.response.CategoryResponse;
import com.viggad.trackingmoney.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class CategoryMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "purchases", ignore = true)
    @Mapping(target = "default", ignore = true)
    @Mapping(target = "account", ignore = true)
    public abstract Category toCategory(CategoryRequest categoryRequest);

    public abstract CategoryResponse toCategoryResponse(Category category);
}
