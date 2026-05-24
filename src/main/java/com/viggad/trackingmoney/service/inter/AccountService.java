package com.viggad.trackingmoney.service.inter;

import com.viggad.trackingmoney.dto.request.AccountRequest;
import com.viggad.trackingmoney.model.Account;

public interface AccountService {
    String createAccount(AccountRequest accountRequest);
}
