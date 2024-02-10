package com.example.accmsbackend.service;

import com.example.accmsbackend.domain.Account;
import com.example.accmsbackend.domain.Custom;
import com.example.accmsbackend.domain.CustomAccountRequest;
import com.example.accmsbackend.mapper.AccountMapper;
import com.example.accmsbackend.mapper.CustomMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public boolean delete(CustomAccountRequest request) {
        try {
            accountMapper.delete(request.getAccount());
            customMapper.delete(request.getCustom());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<CustomAccountRequest> list(Custom custom, Account account) {
        List<Custom> customList = customMapper.list(custom);
        List<Account> accountList = accountMapper.list(account);

        // customList와 accountList를 합쳐서 CustomAccountRequest로 변환하여 반환
        List<CustomAccountRequest> resultList = mergeLists(customList, accountList);
        return resultList;

    }

    private List<CustomAccountRequest> mergeLists(List<Custom> customList, List<Account> accountList) {
        List<CustomAccountRequest> resultList = new ArrayList<>();

        // customList와 accountList를 결합하여 CustomAccountRequest로 변환하고 resultList에 추가
        for (int i = 0; i < Math.min(customList.size(), accountList.size()); i++) {
            Custom custom = customList.get(i);
            Account account = accountList.get(i);

            CustomAccountRequest request = new CustomAccountRequest();
            request.setCustom(custom);
            request.setAccount(account);

            resultList.add(request);
        }

        return resultList;
    }

    public boolean update(CustomAccountRequest request) {
        try {
            accountMapper.update(request.getAccount());
            customMapper.update(request.getCustom());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
