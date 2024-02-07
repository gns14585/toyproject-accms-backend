package com.example.accmsbackend.mapper;

import com.example.accmsbackend.domain.Account;
import com.example.accmsbackend.domain.Custom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper {

    @Insert("""
            INSERT INTO account (offices, bankingInformation, accountNumber, companyNumber)
            VALUES (#{offices}, #{bankingInformation}, #{accountNumber}, #{companyNumber})
            """)
    void insert(Account account);
}
