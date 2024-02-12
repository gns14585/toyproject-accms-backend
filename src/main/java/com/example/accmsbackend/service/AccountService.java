package com.example.accmsbackend.service;

import com.example.accmsbackend.dto.CustomAccountDto;
import com.example.accmsbackend.mapper.AccountMapper;
import com.example.accmsbackend.mapper.CustomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Map<String, Object> list(Integer page) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> pageInfo = new HashMap<>();

        int countAll = customMapper.countAll();

        int lastPageNumber = (countAll - 1) / 10 + 1;
        int startPageNumber = (page - 1) / 10 * 10 + 1;
        int endPageNumber = startPageNumber + 9;
        endPageNumber = Math.min(endPageNumber, lastPageNumber);
        int prevPageNumber = startPageNumber - 10;
        int nextPageNumber = endPageNumber + 1;

        pageInfo.put("currentPageNumber", page);
        pageInfo.put("startPageNumber", startPageNumber);
        pageInfo.put("endPageNumber", endPageNumber);
        if (prevPageNumber > 0) {
            pageInfo.put("prevPageNumber", prevPageNumber);
        }
        if (nextPageNumber <= lastPageNumber) {
            pageInfo.put("nextPageNumber", nextPageNumber);
        }

        int from = (page - 1) * 10;

        map.put("accountList", customMapper.listCustomAccounts(from));
        map.put("pageInfo", pageInfo);

        return map;
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
