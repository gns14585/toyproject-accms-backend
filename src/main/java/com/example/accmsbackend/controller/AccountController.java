package com.example.accmsbackend.controller;

import com.example.accmsbackend.dto.CustomAccountDto;
import com.example.accmsbackend.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
@Transactional
public class AccountController {

    private final AccountService accountService;

    // ------------------------------ 거래처 신규 등록 ------------------------------
    @PostMapping("add")
    public void add(@RequestBody CustomAccountDto request) {
        System.out.println("request = " + request);
        accountService.insert(request);
    }

    // ------------------------------ 거래처 삭제 ------------------------------
    @DeleteMapping("delete")
    public ResponseEntity delete(@RequestBody CustomAccountDto request) {
        if (request == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if (accountService.delete(request)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.internalServerError().build();
    }

    // ------------------------------ 거래처목록 불러오기 ------------------------------
    @GetMapping("list")
    public List<CustomAccountDto> list() {
        return accountService.list();
    }

    // ------------------------------ 거래처 수정 ------------------------------
    @PutMapping("edit")
    public ResponseEntity edit(@RequestBody CustomAccountDto request) {
        if (request == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if (accountService.update(request)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.internalServerError().build();
    }
}
