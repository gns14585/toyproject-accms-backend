package com.example.accmsbackend.mapper;

import com.example.accmsbackend.domain.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AccountMapper {

    @Insert("""
            INSERT INTO account (offices, bankingInformation, accountNumber, companyNumber)
            VALUES (#{offices}, #{bankingInformation}, #{accountNumber}, #{companyNumber})
            """)
    void insert(Account account);


    @Delete("""
            DELETE FROM account
            WHERE companyNumber = #{companyNumber}
            """)
    int delete(Account companyNumber);

    @Select("""
            SELECT *
            FROM account
            ORDER BY regTime DESC
            """)
    List<Account> list(Account account);

    @Update("""
            UPDATE account a
            JOIN custom c ON a.companyNumber = c.companyNumber
            SET
                offices = #{offices},
                accountNumber = #{accountNumber},
                bankingInformation = #{bankingInformation}
            WHERE c.companyNumber = #{companyNumber}
            """)
    int update(Account account);
}
