package com.example.accmsbackend.controller;

import com.example.accmsbackend.domain.Account;
import com.example.accmsbackend.domain.Custom;
import com.example.accmsbackend.domain.CustomAccountRequest;
import com.example.accmsbackend.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;


    @RequestMapping("add")
    @Transactional
    public void add(@RequestBody CustomAccountRequest request) {
        accountService.insert(request);
    }
}
