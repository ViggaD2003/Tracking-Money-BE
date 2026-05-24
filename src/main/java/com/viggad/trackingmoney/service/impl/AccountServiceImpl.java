package com.viggad.trackingmoney.service.impl;

import com.viggad.trackingmoney.dto.request.AccountRequest;
import com.viggad.trackingmoney.mapper.AccountMapper;
import com.viggad.trackingmoney.model.Account;
import com.viggad.trackingmoney.repository.AccountRepository;
import com.viggad.trackingmoney.service.inter.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    private final AccountMapper accountMapper;

    @Override
    public String createAccount(AccountRequest accountRequest) {
        Account account = accountMapper.toAccount(accountRequest);

        accountRepository.save(account);
        return "Register successfully";
    }
}
