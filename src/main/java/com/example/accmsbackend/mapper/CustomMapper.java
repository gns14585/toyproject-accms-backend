package com.example.accmsbackend.mapper;

import com.example.accmsbackend.domain.Custom;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

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
}
