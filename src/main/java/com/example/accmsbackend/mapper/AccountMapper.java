package com.example.accmsbackend.mapper;

import com.example.accmsbackend.domain.Account;
import com.example.accmsbackend.dto.CustomAccountDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountMapper {

    @Insert("""
            INSERT INTO account (offices, bankingInformation, accountNumber, companyNumber)
            VALUES (#{offices}, #{bankingInformation}, #{accountNumber}, #{companyNumber})
            """)
    void insert(CustomAccountDto account);


    @Delete("""
            DELETE FROM account
            WHERE companyNumber = #{companyNumber}
            """)
    int delete(CustomAccountDto companyNumber);

    @Update("""
            UPDATE account a
            JOIN custom c ON a.companyNumber = c.companyNumber
            SET
                offices = #{offices},
                accountNumber = #{accountNumber},
                bankingInformation = #{bankingInformation}
            WHERE c.companyNumber = #{companyNumber}
            """)
    int update(CustomAccountDto account);
}
