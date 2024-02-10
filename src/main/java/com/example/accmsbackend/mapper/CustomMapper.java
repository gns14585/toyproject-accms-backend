package com.example.accmsbackend.mapper;

import com.example.accmsbackend.domain.Custom;
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
    void insert(Custom custom);


    @Delete("""
            DELETE FROM custom
            WHERE companyNumber = #{companyNumber}
            """)
    int delete(Custom companyNumber);

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
    int update(Custom custom);
}
