package com.example.accmsbackend.service;

import com.example.accmsbackend.domain.Account;
import com.example.accmsbackend.domain.Custom;
import com.example.accmsbackend.domain.CustomAccountRequest;
import com.example.accmsbackend.mapper.AccountMapper;
import com.example.accmsbackend.mapper.CustomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountMapper accountMapper;
    private final CustomMapper customMapper;

    public void insert(CustomAccountRequest request) {
        Custom custom = request.getCustom();
        Account account = request.getAccount();

        customMapper.insert(custom);
        accountMapper.insert(account);
    }
}
