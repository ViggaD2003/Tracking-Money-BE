package com.viggad.trackingmoney.mapper;
import com.viggad.trackingmoney.dto.request.PurchaseRequest;
import com.viggad.trackingmoney.dto.response.PurchaseResponse;
import com.viggad.trackingmoney.model.Purchase;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        uses = {CategoryMapper.class}
)
public abstract class PurchaseMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "account", ignore = true)
    @Mapping(target = "category", ignore = true)
    public abstract Purchase toPurchase(PurchaseRequest purchase);

    @Mapping(target = "categoryResponse", source = "category")
    public abstract PurchaseResponse toPurchaseRequest(Purchase purchase);
}
