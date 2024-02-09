package com.example.accmsbackend.controller;

import com.example.accmsbackend.domain.CustomAccountRequest;
import com.example.accmsbackend.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
@Transactional
public class AccountController {

    private final AccountService accountService;

    // ------------------------------ 거래처 신규 등록 ------------------------------
    @RequestMapping("add")
    public void add(@RequestBody CustomAccountRequest request) {
        accountService.insert(request);
    }

    // ------------------------------ 거래처 삭제 ------------------------------
    @DeleteMapping("delete")
    public ResponseEntity delete(@RequestBody CustomAccountRequest request) {
        System.out.println("request = " + request);
        if (request == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if (accountService.delete(request)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.internalServerError().build();
    }
}
