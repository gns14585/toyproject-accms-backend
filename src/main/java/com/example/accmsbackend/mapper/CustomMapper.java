package com.example.accmsbackend.mapper;

import com.example.accmsbackend.dto.CustomAccountDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomMapper {
    @Insert("""
            INSERT INTO custom (companyNumber, 
                abbreviated, 
                companyName, 
                representative, 
                responsiblefor, 
                businessType, 
                items, 
                postalCode, 
                primaryAddress, 
                detailedAddress, 
                phoneNumber, 
                faxNumber, 
                homepageurl, 
                companyType, 
                countryType, 
                contractPeriod1, 
                contractPeriod2, 
                registrationInformation, 
                registrationDateTime, 
                changeInformation, 
                changeDateTime)
            VALUES 
                (#{companyNumber},
                #{abbreviated},
                #{companyName},
                #{representative},
                #{responsiblefor},
                #{businessType},
                #{items},
                #{postalCode},
                #{primaryAddress},
                #{detailedAddress},
                #{phoneNumber},
                #{faxNumber},
                #{homepageurl},
                #{companyType},
                #{countryType},
                #{contractPeriod1},
                #{contractPeriod2},
                #{registrationInformation},
                #{registrationDateTime},
                #{changeInformation},
                #{changeDateTime})
            """)
    void insert(CustomAccountDto custom);


    @Delete("""
            DELETE FROM custom
            WHERE companyNumber = #{companyNumber}
            """)
    int delete(CustomAccountDto companyNumber);

    @Update("""
            UPDATE custom
            SET
                abbreviated = #{abbreviated},
                companyName = #{companyName},
                representative = #{representative},
                responsiblefor = #{responsiblefor},
                businessType = #{businessType},
                items = #{items},
                postalCode = #{postalCode},
                primaryAddress = #{primaryAddress},
                detailedAddress = #{detailedAddress},
                phoneNumber = #{phoneNumber},
                faxNumber = #{faxNumber},
                homepageurl = #{homepageurl},
                companyType = #{companyType},
                countryType = #{countryType},
                contractPeriod1 = #{contractPeriod1},
                contractPeriod2 = #{contractPeriod2},
                registrationInformation = #{registrationInformation},
                registrationDateTime = #{registrationDateTime},
                changeInformation = #{changeInformation},
                changeDateTime = #{changeDateTime}
            WHERE companyNumber = #{companyNumber}
            """)
    int update(CustomAccountDto custom);

@Select("""
            SELECT c.*, a.*
            FROM custom c JOIN account a ON c.companyNumber = a.companyNumber
            WHERE ('' = #{businessNumber} OR c.companyNumber LIKE CONCAT('%', #{businessNumber}, '%'))
            AND ('' = #{companyName} OR c.companyName LIKE CONCAT('%', #{companyName}, '%'))
            ORDER BY a.regTime DESC
            LIMIT #{from}, 10
        """)
List<CustomAccountDto> listCustomAccounts(Integer from, String businessNumber, String companyName);


    @Select("""
            SELECT COUNT(*)
            FROM custom
            WHERE ('' = #{businessNumber} OR companyNumber LIKE CONCAT('%', #{businessNumber}, '%'))
            AND ('' = #{companyName} OR companyName LIKE CONCAT('%', #{companyName}, '%'))
            """)
    int countAll(String businessNumber, String companyName);
}
