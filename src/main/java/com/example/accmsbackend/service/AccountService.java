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

    // ------------------------------ 거래처 신규 등록 ------------------------------
    public void insert(CustomAccountDto request) {
        customMapper.insert(request);
        accountMapper.insert(request);
    }

    // ------------------------------ 거래처 삭제 ------------------------------
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

    // ------------------------------ 거래처목록 불러오기 ------------------------------
    public List<CustomAccountDto> list(Integer page) {

        int from = (page - 1) * 10;

        return customMapper.listCustomAccounts(from);
    }

    // ------------------------------ 거래처 수정 ------------------------------
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
