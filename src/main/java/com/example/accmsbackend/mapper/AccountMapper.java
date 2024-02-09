package com.example.accmsbackend.mapper;

import com.example.accmsbackend.domain.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
            """)
    List<Account> list(Account account);
}
