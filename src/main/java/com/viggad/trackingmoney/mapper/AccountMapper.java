package com.viggad.trackingmoney.mapper;

import com.viggad.trackingmoney.dto.request.AccountRequest;
import com.viggad.trackingmoney.model.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring"
)
public abstract class AccountMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "purchases", ignore = true)
    @Mapping(target = "categories", ignore = true)
    public abstract Account toAccount(AccountRequest accountRequest);

}
