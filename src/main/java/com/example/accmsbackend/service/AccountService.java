package com.example.accmsbackend.service;

import com.example.accmsbackend.dto.CustomAccountDto;
import com.example.accmsbackend.mapper.AccountMapper;
import com.example.accmsbackend.mapper.CustomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountMapper accountMapper;
    private final CustomMapper customMapper;

    public void insert(CustomAccountDto request) {


        customMapper.insert(request);
        accountMapper.insert(request);
    }

    public boolean delete(CustomAccountDto request) {
        try {
            accountMapper.delete(request);
            customMapper.delete(request);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<CustomAccountDto> list() {
        return customMapper.listCustomAccounts();
    }

    public boolean update(CustomAccountDto request) {
        try {
            accountMapper.update(request);
            customMapper.update(request);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
