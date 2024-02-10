package com.example.accmsbackend.mapper;

import com.example.accmsbackend.domain.Custom;
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

    @Select("""
            SELECT *
            FROM custom
            ORDER BY regTime DESC
            """)
    List<Custom> list(Custom request);


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
            ORDER BY a.regTime DESC
            """)
    List<CustomAccountDto> listCustomAccounts();

}
