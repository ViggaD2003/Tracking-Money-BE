package com.viggad.trackingmoney.controller;

import com.viggad.trackingmoney.dto.request.AccountRequest;
import com.viggad.trackingmoney.model.Account;
import com.viggad.trackingmoney.service.inter.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity<String> createAccount(@RequestBody AccountRequest account) {
        String response = accountService.createAccount(account);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
